package harjoitukset;

import java.util.Scanner;

public class CaesarCode {

    private static String teksti = null;
    private static String teksti2 = null;
    private static int kokeiluja = 13;

    public static void main(String[] args) {

        CaesarCode salaaja = new CaesarCode();
        
        Scanner in = new Scanner(System.in);
        
        // UTQUX AZOOT OBGRZ ZGSGZ UTVGN GBGON EBK
        // onkorutiinivalttamatonpahavaihyve (-6)
        
        System.out.println("Minkä tekstin haluat avata?");
        teksti2 = in.nextLine();
        System.out.println("Millä kertoimilla haluat kokeilla avausta? +/- (0-x)");
        kokeiluja = Integer.parseInt(in.nextLine());
        
        salaaja.pureKokeile(teksti2, kokeiluja);

        /*

        System.out.println("Minkä tekstin haluat salata?");

        teksti = in.nextLine();

        String salattu = salaaja.salaa(teksti);
        System.out.println("Salattu teksti on: " + salattu);

        String purettu = salaaja.pure(salattu);
        System.out.println("Purettu teksti on: " + purettu);
         */
        
        /*
        System.out.println(teksti);
        
        salateksti = salaa(teksti);
        
        System.out.println(salateksti);
        
        purkuteksti = pure(salateksti);
        
        System.out.println(purkuteksti);
        
        System.out.println("Täsmääkö alkuperäinen ja purkuteksti? " + (teksti.equals(purkuteksti)));
         */
    }

    public void CaesarCode() {
    }

    private String salaa(String s) {

        System.out.println("\nAnnettu salattava teksti on: " + s);

        String salattu = "";
        String salattava = s.replaceAll(" ", "");
        char[] merkit = salattava.toLowerCase().toCharArray();

        // System.out.println("Väliaikainen salattava: " + salattava);
        for (int i = 0; i < merkit.length; i++) {
            salattu += (char) (merkit[i] + 3);
            if ((i + 1) % 5 == 0) {
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

    private void pureKokeile(String s, int j) {

        System.out.println("\nAnnettu purettava on: " + s);

        char[] merkit = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "").toCharArray();

        System.out.println("");

        for (int x = 1; x <= j; x++) {
            String purettu = "";

            for (int i = 0; i < merkit.length; i++) {

                char c;
                
                if ((merkit[i] - 97 - x) < 0) {
                    int mod = -1 * (merkit[i] - 97 - x);
                    while (mod > 26) {
                        mod -= 26;
                    }
                    c = (char) (123 - mod);
                } else {
                    c = (char) (merkit[i] - x);
                }

                purettu += c;
            }

            System.out.println("Purkuavain -" + x + ": " + purettu);
        }

        System.out.println("");

        for (int x = 1; x <= j; x++) {
            String purettu = "";

            for (int i = 0; i < merkit.length; i++) {
                
                char c;
                
                if ((merkit[i] + x) > 122) {
                    int mod = merkit[i] + x - 122;
                    while (mod > 26) {
                        mod -= 26;
                    }
                    c = (char) (96 + mod);
                } else {
                    c = (char) (merkit[i] + x);
                }
                
                purettu += c;
            }

            System.out.println("Purkuavain +" + x + ": " + purettu);
        }
    }

}
