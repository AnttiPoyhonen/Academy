package harjoituksia;

import java.util.Scanner;

public class BinaariLaskin {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean virheita = true;

        String luku1 = "", luku2 = "";

        jatka:
        while (virheita) {

            // estimating exit of while, unless errors discovered in foreach
            virheita = false;

            System.out.print("Syötä ensimmäinen binääriluku: ");
            luku1 = in.next();

            char[] ch1 = luku1.toCharArray();

            for (char ch : ch1) {
                if (ch == '1' || ch == '0') {
                } else {
                    System.out.println("Syötteessä1 ei ollut pelkkiä binäärejä!");
                    System.out.println("Syötä uudet luvut.\n");
                    virheita = true;
                }
            }
            if (virheita) {
                continue;
            }

            System.out.print("Ensimmäinen binääriluku: ");

            for (char ch : ch1) {
                System.out.print(ch);
            }
            System.out.println(", eli " + Long.parseLong(luku1, 2));

            System.out.print("\nSyötä toinen binääriluku: ");
            luku2 = in.next();

            char[] ch2 = luku2.toCharArray();

            for (char ch : ch2) {
                if (ch == '1' || ch == '0') {
                } else {
                    System.out.println("Syötteessä2 ei ollut pelkkiä binäärejä!");
                    System.out.println("Syötä uudet luvut.\n");
                    virheita = true;
                }
            }
            if (virheita) {
                continue;
            }

            System.out.print("Toinen binääriluku: ");

            for (char ch : ch2) {
                System.out.print(ch);
            }
            System.out.println(", eli " + Long.parseLong(luku2, 2) + "\n");

        }
        
        long tulos;
        
        System.out.print("Mitä haluat luvuille tehdä? ( syötä operaattori +, -, * tai / ) ");
        String operaattori = in.next();
        
        switch (operaattori){
            case "+":
                tulos = Long.parseLong(luku1, 2) + Long.parseLong(luku2, 2);
                System.out.println("Binäärilukujen summma: " + Long.toBinaryString(tulos) + ", eli " + tulos);
                break;
            case "-":
                tulos = Long.parseLong(luku1, 2) - Long.parseLong(luku2, 2);
                System.out.println("Binäärilukujen summma: " + Long.toBinaryString(tulos) + ", eli " + tulos);
                break;
            case "*":
                tulos = Long.parseLong(luku1, 2) * Long.parseLong(luku2, 2);
                System.out.println("Binäärilukujen tulo: " + Long.toBinaryString(tulos) + ", eli " + tulos);
                break;
            case "/":
                if (Long.parseLong(luku2, 2) == 0){
                    System.out.println("Ei voida jakaa nollalla!");
                    break;
                }
                double jakotulos = Double.parseDouble(luku1) / Double.parseDouble(luku2);
                System.out.println("Binäärilukujen jakotulo desimaalina: " + jakotulos);
                break;
            default:
                System.out.println("Ei kelvollinen operaattori!\n");
                break;
            
        }

        /* Summa ennen operaattorivalintaa
        long summa = Long.parseLong(luku1, 2) + Long.parseLong(luku2, 2);

        System.out.println("Binäärilukujen summma: " + Long.toBinaryString(summa) + ", eli " + summa);
        */

        // */
        // simple version, works 
        /*
        System.out.print("Syötä ensimmäinen binääriluku: ");
        String luku1 = in.next();

        System.out.print("Syötä toinen binääriluku: ");
        String luku2 = in.next();

        long summa = Long.parseLong(luku1, 2) + Long.parseLong(luku2, 2);

        System.out.println("Binäärilukujen summma: " + Long.toBinaryString(summa));
         */
    }
}
