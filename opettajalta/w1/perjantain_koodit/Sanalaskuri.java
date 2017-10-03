package fi.academy.perjantai;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Sanalaskuri {
    private static final Sanalaskuri laskuri = new Sanalaskuri();
    public static void main(String[] args) {
        laskuri.kasitteleTiedosto(luokastaPoluksi(Sanalaskuri.class));
        laskuri.tulostaKartta();

        //laskuri.tulostaKartta(true);

//        kasittelejatulosta(fi.academy.torstai.ListaHarjoitus1.class);
//        kasittelejatulosta(String.class);

    }

    // Luokan ei-staattiset jäsenet:
    private boolean ignoreCase;             // onko if ja IF sama sana
    private Map<String, Integer> sanadata;  // tähän tilasto
    private int pisinSana;                  // apumuuttuja tulostuksen siistimiseen
    private String tiedostonNimi;

    private void kasitteleTiedosto(Path tiedosto) {
        pisinSana = -1; // apumuuttuja, käytetään myöhemmin  tulostuksessa
        tiedostonNimi = "????";
        try (BufferedReader kahva = new BufferedReader(new FileReader(tiedosto.toFile()))) {
            tiedostonNimi = tiedosto.toString();
            sanadata = new TreeMap<>();
            for(String rivi = kahva.readLine() ; rivi != null ; rivi=kahva.readLine()) {
                // Toimii vain ASCII merkeillä
                String[] sanat = rivi.split("\\W+");
                for(String sana : sanat) {
                    if (ignoreCase)  sana = sana.toLowerCase();
                    if(!sana.isEmpty()) {
                        if (sanadata.containsKey(sana)) {
                            int vanha = sanadata.get(sana);
                            sanadata.put(sana, vanha+1);
                        } else {
                            sanadata.put(sana, Integer.valueOf(1));
                            int pit = sana.length();
                            if (pit > pisinSana) pisinSana = pit;
                        }
                    }
                }
            }
            ++pisinSana;
        } catch (FileNotFoundException e) {
            System.err.println(String.format("Tiedostoa '%s' ei löydy! Ei frekvenssidataa", tiedosto));
            sanadata = Collections.EMPTY_MAP;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void tulostaKartta() {
        tulostaKartta(false);
    }

    private void tulostaKartta(boolean jarjesta) {
        System.out.println("\n-------------------------------");
        System.out.println(tiedostonNimi);
        System.out.println();
        if (jarjesta) {
            tulostaJarjestyksessa();
        } else {
            tulostaOletuksilla();
        }
    }

    private void tulostaOletuksilla() {
        for (Map.Entry<String, Integer> pari : sanadata.entrySet()) {
            tulostaSanaRivi(pari.getKey(), pari.getValue());
        }
    }

    private void tulostaSanaRivi(String sana, Integer maara) {
        System.out.println(String.format("%-"+pisinSana+"s: %d", sana, maara));
    }

    // Lisätehtävä:
    private void tulostaJarjestyksessa() {
        // Ensin kopioidaan data Mapista listaan
        List<Map.Entry<String, Integer>> lista
                = new LinkedList<Map.Entry<String, Integer>>(sanadata.entrySet());
        // Sitten sortataan lista (joka pitää lisäysjärjestyksen)
        Collections.sort( lista, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        // Lopuksi tulostetaan järjestetty lista
        for(Map.Entry<String, Integer> pari : lista) {
            tulostaSanaRivi(pari.getKey(), pari.getValue());
        }
    }


    // <editor-fold desc="Piilotettu staattisia apumetodeja..">
    private static void kasittelejatulosta(Class luokka) {
        Path polku = luokastaPoluksi(luokka);
        laskuri.kasitteleTiedosto(polku);
        laskuri.tulostaKartta(true);
    }

    private static Path luokastaPoluksi(Class luokka) {
        return Paths.get("src", paketistaPoluksi(luokka.getCanonicalName())+".java");
    }
    private static String paketistaPoluksi(String paketti) {
        return paketti.replace('.', '/');
    }
    //</editor-fold>
}

