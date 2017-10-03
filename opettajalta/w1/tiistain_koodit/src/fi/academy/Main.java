package fi.academy;

import fi.academy.tiistai.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Harjoitukset: Main, aja yksittäiset osat - tai poista tästä kommentit");
        System.out.println(0.1+0.2);
//        binaarisumma();
//	    Kertoma.run();
//	    LukuTaulu.main(args);
//	    Binaarilaskin.run();
//	    new Arvauspeli().pelaa();
    }

    protected static void binaarisumma() {
        Scanner in = new Scanner(System.in);
        long luku1, luku2;

        String rivi = in.nextLine();
        String [] sanat = rivi.split(" ");
        luku1 = Long.parseLong(sanat[0], 2);
        luku2 = Long.parseLong(sanat[2], 2);
        String operaattori = sanat[1];
        long tulos = 0;
        if ("+".equals(operaattori)) {
            tulos = luku1 + luku2;
        } else if ("*".equals(operaattori)) {
            tulos = luku1 * luku2;
        }
        String ulos = String.format("%s %s %s = %s",
                Long.toBinaryString(luku1),
                operaattori,
                Long.toBinaryString(luku2),
                Long.toBinaryString(tulos)
                );
        System.out.println(ulos);
//        System.out.println(Long.toBinaryString(luku1)
//                + " + "
//                + Long.toBinaryString(luku2)
//                + " = "
//                + Long.toBinaryString(luku1+luku2));
    }

}
