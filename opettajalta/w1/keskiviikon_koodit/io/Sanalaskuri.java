package fi.academy.keskiviikko.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Sanalaskuri {
    public static void main(String[] args) {
        Sanalaskuri sanalaskuri = new Sanalaskuri();
        if (args.length > 0) {
            sanalaskuri.lueJaTulosta(args[0]);
        } else {
            sanalaskuri.lueJaTulosta("tiedosto.txt");
            sanalaskuri.lueJaTulosta("src/fi/academy/keskiviikko/io/Sanalaskuri.java");
        }
    }

    private int sanat, merkit, rivit;
    private String nimi;

    private void lueJaTulosta(String nimi) {
        lueTiedosto(nimi);
        tulostaTiedot();
    }

    private void lueTiedosto(String nimi) {
        try (BufferedReader kahva = new BufferedReader(new FileReader(nimi))) {
            this.nimi = nimi;
            for(String rivi = kahva.readLine() ; rivi != null ; rivi=kahva.readLine()) {
                rivit += 1;
                merkit += rivi.length();
                sanat +=  rivi.split("\\s").length;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void tulostaTiedot() {
        System.out.println(String.format("Tiedosto: %s\n\t%d\t%d\t%d", nimi, rivit, sanat, merkit));
    }

    String [] sanat(String rivi) {
        // Toimii vain ASCII merkeillä
        String[] sanat = rivi.split("\\W+");
//        for(String sana : sanat) {
//            if(!sana.isEmpty())
//                System.out.println(sana);
//        }
        return sanat;
    }
}
