package fi.academy.tiistai;

import java.util.Random;
import java.util.Scanner;

public class Arvauspeli {
    private static int MAX_LUKU = 100;
    public static void main(String[]args) {
        run();
    }
    public static void run() {
        new Arvauspeli().pelaa();
    }
    private Random rnd = new Random();

    public void pelaa() {
        System.out.print("Tervetuloa pelaamaan. ");
        int max = MAX_LUKU;
        System.out.println(String.format("Anna suurin arvottava luku, Enter käyttää oletusta %d", MAX_LUKU));
        try (Scanner in = new Scanner(System.in)) {
            String vastaus = in.nextLine();
            if (!"".equals(vastaus.trim())) {
                max = Integer.parseInt(vastaus);
            }
            for(; ;) {
                pelaaKierros(in, max);
                if(lopetetaan())
                    break;
            }
            System.out.println("Hyvä peli!");
        } catch (Exception e) {
            System.err.println("Ongelma Scannerin kanssa: " +  e.getMessage());
        }

    }

    private boolean lopetetaan() {
        return true;
    }

    private void pelaaKierros(Scanner in, int max) {
        int salainen = rnd.nextInt(max);
        System.out.println("salainen: " + salainen);
        for(; ;) {
            System.out.print("Arvaus: ");
            System.out.flush();
            int vastaus = in.nextInt();
            if (vastaus == salainen) {
                System.out.println("Oikein!");
                return; // tai break;
            } else {
                String suunta = vastaus < salainen ? "pieni" : "suuri";
                System.out.println("Arvauksesi oli liian " + suunta);
            }
        }

    }
}
