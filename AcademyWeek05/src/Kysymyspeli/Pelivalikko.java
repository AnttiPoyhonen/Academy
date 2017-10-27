package Kysymyspeli;

import java.util.Scanner;

class Pelivalikko {

    public static void run() {
        
        Scanner in = new Scanner(System.in);
        
        outer:
        for(;;) {
            
            System.out.println("\n\t\tGAME MENU: \n   What type of questions do you want to answer?\n\n"
                    + "\t" + "1 - Java" + "\t" + "9 - Add Questions" + "\n"
                    + "\t" + "2 - Java SE 8" + "\t" + "0 - Quit the game" + "\n"
                    + "\t" + "3 - SCRUM" + "\n");
                    
            System.out.print("\t");
            String valinta = in.nextLine();
            
            switch (valinta) {
                case "1":
                case "2":
                case "3":
                    Kysy.pelaa(Integer.parseInt(valinta), in);
                    break;
                case "9":
                    Kysy.inputKysymys(in);
                    break;
                case "0":
                    break outer;
                default:
                    System.out.print("   ");
                    System.out.println("You did not choose, choose again.");
            }
            
            Kysy.nykyinenkysymys = 0;
            Kysy.pisteet = 0;
        }
        
        System.out.println("\n   Thank you for playing!\n");
        
    }
    
}
