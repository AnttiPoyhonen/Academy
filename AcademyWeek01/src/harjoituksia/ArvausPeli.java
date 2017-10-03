package harjoituksia;

import java.util.InputMismatchException;
import java.util.Scanner;

// tulostaa "haluatko uuden pelin" ja defaultin ennen syötettä!
public class ArvausPeli {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int arvaus;

        outer:
        while (true) {

            int arvauksia = 0;
            int rand = (int) (Math.random() * 100 + 1);

            System.out.print("Montako arvausta sallitaan pelissä: ");
            int maxArvauksia = in.nextInt();
            System.out.println("Tässä pelissä sallitaan " + maxArvauksia + " arvausta.\n");

            while (true) {

                for (;;) {
                    try {
                        System.out.print("Anna arvaus (1-100): ");
                        arvaus = in.nextInt();
                        arvauksia++;
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Ei ollut integer, koeta uudestaan.");
                        in.nextLine();
                    }
                }

                if (arvaus == rand) {
                    System.out.println("Arvasit oikein!");
                    break;
                } else if (arvaus < 1 || arvaus > 100) {
                    System.out.println("Virheellinen syöte!");
                } else if (arvaus > rand) {
                    System.out.println("Arvaus oli liian suuri!");
                } else {
                    System.out.println("Arvaus oli liian pieni!");
                }
                if (arvauksia == maxArvauksia) {
                    System.out.println("Maksimimäärä arvauksia! Lopetetaan...");
                    break;
                }
            }

            jatko:
            while (true) {
                in.nextLine(); // tyhjentää bufferin siirtymällä seuraavalle riville
                System.out.println("\nHaluatko uuden pelin? (k/e) ");
                String jatkoon = in.nextLine();
                switch (jatkoon) {
                    case "k":
                        System.out.println("");
                        break jatko;
                    case "e":
                        System.out.println("Lopetetaan.\n");
                        break outer;
                    default:
                        System.out.println("Väärä syöte!");
                }
            }

        }

    }

}
