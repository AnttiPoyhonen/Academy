package harjoituksia;

import java.util.Scanner;

public class PerheNimet {

    static String etunimi = null, toinenNimi = null, sukunimi = null, isa = null, aiti = null, sisar = null;

    static String[] perhe = {"Antti Johannes Pöyhönen", "Mirka Nina Marjatta Pöyhönen", "Olivia Ilona Pöyhönen", "Henrietta Aura Pöyhönen"};
    static String[] valinnat = {"", "", ""};

    static String perhePrint = "";

    public static void main(String[] args) {
        kysyJaAnnaNimet("etunimi", "toinen nimi", "sukunimi");
    }

    public static void kysyJaAnnaNimet(String nimi, String nimi2, String nimi3) {

        for (String s : perhe) {
            perhePrint += s + ", ";
        }

        valitse(nimi, nimi2, nimi3);

        // isä
        isa = kukaOnKuka(valinnat[0]);
        
        // äiti
        aiti = kukaOnKuka(valinnat[1]);
        
        // sisko
        sisar = kukaOnKuka(valinnat[2]);
        

        System.out.println("\n" + etunimi + " " + toinenNimi + " " + sukunimi);
        System.out.println("Isä on: " + isa);
        System.out.println("Äiti on: " + aiti);
        System.out.println("Sisko on: " + sisar);

        System.out.println("\nKoko Pöyhösten perhe on: " + perhePrint);
    }

    static public String kukaOnKuka(String nimi) {
        switch (nimi) {
            case "Antti":
                return perhe[0];
            case "Mirka":
                return perhe[1];
            case "Olivia":
                return perhe[2];
            case "Henrietta":
                return perhe[3];
            default:
                return nimi;
        }
    }
    
    static public void valitse(String nimi, String nimi2, String nimi3) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Kuka on kyseessä? (" + nimi + ")");
            etunimi = in.nextLine();
            System.out.println("Mikä olikaan " + nimi2 + "?");
            toinenNimi = in.nextLine();
            System.out.println("Mikä on vielä " + nimi3 + "?");
            sukunimi = in.nextLine();
            System.out.println("Kuka on isä? (etunimi)");
            valinnat[0] = in.nextLine();
            System.out.println("Kuka on äiti? (etunimi)");
            valinnat[1] = in.nextLine();
            System.out.println("Kuka on sisko? (etunimi)");
            valinnat[2] = in.nextLine();
        }
    }

}
