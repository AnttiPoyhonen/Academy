package Kysymyspeli;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Kysy {
    
    private static List<Kysymys> kysymykset = new ArrayList<>();
    public static int nykyinenkysymys = 0;
    public static int pisteet = 0;

        
    static void pelaa(int tyyppi, Scanner in) {
        
        int max = 1;
        
        try {
            
            haeKysymykset(tyyppi);
            max = kysymykset.size();
            
        } catch (SQLException ex) {
            
            System.out.print("   ");
            System.out.println("Problem getting the questions! Returning...");
            System.out.print("   ");
            System.out.println(ex.getMessage());
            
        }
        
        for(;;) {
            
            System.out.println("\n   How many questions do you want to answer? (number, " + max + " maximum, 0 quits)");
            
            int kierroksia = kysyKierroksia(in);
            
            if (kierroksia == -1) continue;
            if (kierroksia == 0) return;
            if (kierroksia > 0 && kierroksia <= max) break;
            
            System.out.println("   You did not choose a number between 1 - max.");
            
        }
        
        pelaaKierrokset(in, max);
        
    }
    
    
    private static void haeKysymykset(int tyyppi) throws SQLException {
        
        kysymykset = Connect.haeKysymykset(tyyppi);
        
    }
    
    
    private static int kysyKierroksia(Scanner in) {
        
            int kierroksia = -1;
            
            try {
                
                System.out.print("   ");
                kierroksia = Integer.parseInt(in.nextLine());
                
            } catch (NumberFormatException e) {
                System.out.print("   ");
                System.out.println("You did not input a number! Try again.");
                return kierroksia;
            }
                        
            return kierroksia;
    }

    
    private static void pelaaKierrokset(Scanner in, int max) {
            
        int pelattu = 0;
        
        for(;;) {
            
            // kysy kierroksen kysymys ja jos oikein (true), laske pisteitä
            if(kysy(in)) {
                
                pisteet++;
                System.out.print("\n   That was CORRECT! Press ENTER to continue...");
                
            } else System.out.print("\n   That was INCORRECT! Press ENTER to continue...");
            
            System.out.print("   ");
            in.nextLine();
            
            pelattu++;
            
            if (pelattu >= max) break;
            
        }
        
        System.out.println("\n   You achieved " + pisteet + " points out of " + pelattu + " questions. Congratulations!\n");
        
    }
    

    private static boolean kysy(Scanner in) {
        
        Kysymys k = kysymykset.get(nykyinenkysymys);
        nykyinenkysymys++;
                
        printKysymys(k);
        
        // kategoriaid: 1(multiplechoice), 2(multiplechoice multiple correct), 3(true/false), 4(text input)
        
        if (k.getCategoryid() == 4) return textVastaus(in, k);
        else if (k.getCategoryid() == 2) return multipleMultipleVastaus(in, k);
        else return multipleVastaus(in, k);
                
    }
    
    
    private static void printKysymys(Kysymys k) {
        
        String teksti = k.getText();
                
        System.out.println("\n\n   QUESTION " + nykyinenkysymys + ":"); 
        
        String[] rivit = teksti.split("\n");
        
        for (int i = 0; i < rivit.length; i++) {
            System.out.println("   " + rivit[i]);
        }
        
        if (k.getCategoryid() == 2) {
            System.out.println("\n   (MULTIPLE ANSWERS, write down all correct answer numbers, divided by ',')\n");
        } else if (k.getCategoryid() == 1 || k.getCategoryid() == 3) {
            System.out.println("\n   (MULTIPLE CHOICE, write down your answer number)\n");            
        } else {
            System.out.println("\n   (TEXT QUESTION, write your answer in text form)\n");
        }
                
    }
        
    
    private static boolean multipleVastaus(Scanner in, Kysymys k) {
        
        Map<Integer, Vaihtoehto> vaihtoehdot = k.getVaihtoehdot();
                
        for (int i = 1; i <= vaihtoehdot.size(); i++) {
            System.out.print("   ");
            System.out.println(i + " - " + vaihtoehdot.get(i).getText());
        }
        
        int vastaus = kysyMultipleVastaus(in, vaihtoehdot);
                        
        return vaihtoehdot.get(vastaus).isCorrect();
        
    }
    
    
    private static int kysyMultipleVastaus(Scanner in, Map<Integer, Vaihtoehto> vaihtoehdot) {
            
        int vastaus = 0;
                        
        for(;;) {
            
            try {
                
                System.out.print("   ");
                vastaus = Integer.parseInt(in.nextLine());
                
                if (vastaus <= vaihtoehdot.size() && vastaus > 0) break;
                
                System.out.println("\n   Not an answer. Try again.");
                                
            } catch (NumberFormatException e) {
                System.out.println("\n   You did not input a number! Try again.");
            }
        }
        
        return vastaus;
    }
    
    
    private static boolean multipleMultipleVastaus(Scanner in, Kysymys k) {
        
        Map<Integer, Vaihtoehto> vaihtoehdot = k.getVaihtoehdot();
                
        for (int i = 1; i <= vaihtoehdot.size(); i++) {
            System.out.print("   ");
            System.out.println(i + " - " + vaihtoehdot.get(i).getText());
        }
        
        return kysyMultipleMultipleVastaus(in, vaihtoehdot);
        
    }
    
    
    private static boolean kysyMultipleMultipleVastaus(Scanner in, Map<Integer, Vaihtoehto> vaihtoehdot) {
        
        String vastaus = "";
        
        for(;;) {
            
            System.out.print("   ");
            vastaus = in.nextLine();

            if ("".equals(vastaus)) {
                System.out.println("You did not enter any answer, enter your answers divided by ','");
            } else break;
        }
                
        String[] numerot = vastaus.split("[^0-9]");
        
        if (numerot.length == 0) return false;
        
        List<Integer> vastaukset = new ArrayList<>();
                
        for (int i = 0; i < numerot.length; i++) {
            
            if ("".equals(numerot[i])) continue;
            vastaukset.add(Integer.parseInt(numerot[i]));
            
        }
                
        for (int i = 0; i < vastaukset.size(); i++) {
            if(!vaihtoehdot.get(vastaukset.get(i)).isCorrect()) return false;
        }
                
        return true;
    }
    

    private static boolean textVastaus(Scanner in, Kysymys k) {
                
        String vastaus = kysyTextVastaus(in);
        
        return k.getVaihtoehdot().get(1).getText().equalsIgnoreCase(vastaus);
        
    }
    
    
    private static String kysyTextVastaus(Scanner in) {
        
        String vastaus = "";
        
        for(;;) {
            vastaus = in.nextLine();
            
            if ("".equals(vastaus)) break;
            
            System.out.println("You did not enter any answer, write the answer in text form!");
        }
        
        return vastaus.trim();
        
    }
    
    
    static void inputKysymys(Scanner in) {
                
        outer:
        for(;;) {
            
            System.out.println("\n\t\tADDING A QUESTION:\n" 
                    + "   For which question type do you want to input questions?\n"
                    + "\n"
                    + "\t" + "1 - Java" + "\t" + "0 - Go back to Game Menu" + "\n"
                    + "\t" + "2 - Java SE 8" + "\n"
                    + "\t" + "3 - SCRUM" + "\n"
                    + "\n");
            
            System.out.print("\t");
            String valinta = in.nextLine();
            
            switch (valinta) {
                case "1":
                case "2":
                case "3":
                    Kysymys.lisääKysymys(Integer.parseInt(valinta), in);
                    break;
                case "0":
                    break outer;
                default:
                    System.out.println("   You did not choose, choose again.");
            }
            
        }
        
    }
    
}
