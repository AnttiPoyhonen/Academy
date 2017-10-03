package harjoituksia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Kysymys {
    String kysymys;
    List<String> vaihtoehdot = new ArrayList<>();
    String vastaus;

    public Kysymys(String kysymysteksti, String vaihtoehto1, String vaihtoehto2, String vaihtoehto3, int oikeaVaihtoehto) {
        
        this.kysymys = kysymysteksti;
        
        this.vaihtoehdot.add(vaihtoehto1);
        this.vaihtoehdot.add(vaihtoehto2);
        this.vaihtoehdot.add(vaihtoehto3);
        
        this.vastaus = vaihtoehdot.get(oikeaVaihtoehto);
        
    }

    public boolean kysy() {
        
        System.out.println(kysymys);
        
        Collections.shuffle(vaihtoehdot);
        
        System.out.println("Valitse vaihtoehdoista (A, B, C):"
                + "\nA - " + vaihtoehdot.get(0)
                + "\nB - " + vaihtoehdot.get(1)
                + "\nC - " + vaihtoehdot.get(2) + "\n");

        Scanner in = new Scanner(System.in);
        String vastaa = null;

        outer:
        for (; ; ) {
            vastaa = in.nextLine();
            switch (vastaa) {
                case "a":
                case "A":
                    if (vaihtoehdot.get(0).equals(this.vastaus)) {
                        oikein();
                        return true;
                    } else {
                        vaarin();
                        return false;
                    }
                case "b":
                case "B":
                    if (vaihtoehdot.get(1).equals(this.vastaus)) {
                        oikein();
                        return true;
                    } else {
                        vaarin();
                        return false;
                    }
                case "c":
                case "C":
                    if (vaihtoehdot.get(2).equals(this.vastaus)) {
                        oikein();
                        return true;
                    } else {
                        vaarin();
                        return false;
                    }
                default:
                    System.out.println("Et valinnut vastausta!");
                    continue;
            }
        }
    }

    private void oikein() {
        System.out.println("Vastasit oikein!\n");
    }

    private void vaarin() {
        System.out.println("Väärin!!!\nParempaa onnea ensi kerralla!\n");
    }
}