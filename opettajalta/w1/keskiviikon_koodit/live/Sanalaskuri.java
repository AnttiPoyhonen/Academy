package fi.academy.keskiviikko.live;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sanalaskuri {
    public static void main(String[] args) {
        String tiedostonnimi;
        if(args.length > 0) {
            tiedostonnimi = args[0];
        } else {
            System.out.println("Käytetään oletustiedostonimeä");
            tiedostonnimi = "src/fi/academy/keskiviikko/live/Sanalaskuri.java";
        }
        Sanalaskuri laskuri = new Sanalaskuri();
        laskuri.kasitteleTiedosto(tiedostonnimi);
    }
    private void kasitteleTiedosto(String nimi) {
        int sanat=0, merkit=0, rivit=0;
        try (BufferedReader lukija = new BufferedReader(new FileReader(nimi))) {
            for(String rivi = lukija.readLine() ; rivi != null; rivi = lukija.readLine()) {
                rivit++;  // rivit = rivit + 1;  rivit += 1;
                merkit += rivi.length()+1;
                String [] sanatrivilla = rivi.split("\\W+");
                int sanoja = sanatrivilla.length;
                sanat += sanoja;
            }
            System.out.println("------ " + nimi + " -------");
            System.out.println("\t" + rivit + "\t" + sanat + "\t" + merkit);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
