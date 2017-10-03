package harjoitukset;

import java.util.Scanner;

public class CaesarCode {

    private static String teksti = null;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        System.out.println("Minkä tekstin haluat salata?");
        
        teksti = in.nextLine();
        CaesarCode salaaja = new CaesarCode();
        
        String salattu = salaaja.salaa(teksti);
        System.out.println("Salattu teksti on: " + salattu);
        
        String purettu = salaaja.pure(salattu);
        System.out.println("Purettu teksti on: " + purettu);
        

        /*
        System.out.println(teksti);
        
        salateksti = salaa(teksti);
        
        System.out.println(salateksti);
        
        purkuteksti = pure(salateksti);
        
        System.out.println(purkuteksti);
        
        System.out.println("Täsmääkö alkuperäinen ja purkuteksti? " + (teksti.equals(purkuteksti)));
         */
    }
    
    public void CaesarCode() {}

    private String salaa(String s) {

        System.out.println("\nAnnettu salattava teksti on: " + s);
        
        String salattu = "";
        String salattava = s.replaceAll(" ", "");
        char[] merkit = salattava.toLowerCase().toCharArray();
        
        // System.out.println("Väliaikainen salattava: " + salattava);

        for (int i = 0; i < merkit.length; i++) {
            salattu += (char) (merkit[i] + 3);
            if ((i+1)%5 == 0) {
                salattu += " ";
            }
        }
                        
        return salattu.toUpperCase();
    }

    private String pure(String s) {

        String purettu = "";
        
        System.out.println("\nAnnettu purettava on: " + s);

        char[] merkit = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "").toCharArray();

        for (int i = 0; i < merkit.length; i++) {
            char c = (char) (merkit[i] - 3);
            purettu += c;
        }

        return purettu;
    }

}
