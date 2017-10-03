package fi.academy.keskiviikko.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sanahaku {
    public static void main(String[] args) {
        String[] haettavatSanat = {"main", "foo" + "bar"};
        String tiedostonnimi = "src/fi/academy/keskiviikko/io/Sanahaku.java";

        for (String sana : haettavatSanat) {
            System.out.println("------- " + sana + " ------------");
            boolean loytyi = kasitteleTiedosto(tiedostonnimi, sana, true) ;
            if (loytyi) {
                System.out.println("Löytyi!");
            } else {
                System.out.println("Ei löytynyt");
            }
        }
    }

    private static boolean kasitteleTiedosto(String tiedostonnimi, String haettavaSana, boolean tulostaRivit) {
        int rivinro = 1;
        boolean loytyi = false;
        try (BufferedReader lukija = new BufferedReader(new FileReader(tiedostonnimi))) {
            for(String rivi = lukija.readLine() ; rivi != null ; rivinro++, rivi = lukija.readLine()) {
                if(!rivi.contains(haettavaSana)) continue;
                if(tulostaRivit) {
                    System.out.println(rivinro + ": " + rivi);
                    loytyi = true;
                } else {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loytyi;
    }
}
