package harjoituksia;

import java.lang.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapSanalaskuri {

    // Tiedoston luku, ja sanoihin jako
    static String luettava = "src/harjoituksia/MapSanalaskuri.java";
    static Map<String, Integer> m = new TreeMap<>();
    static Map<String, Integer> jarjestetty = new LinkedHashMap<>();

    public static void main(String[] args) {

        readFile();

        System.out.println("Lista aakkosjärjestyksessä (TreeMap):");
        printMap(m);

        jarjesta((TreeMap) m);

        System.out.println("\nLista järjestettynä:");
        printMap(jarjestetty);

    }

    static private void readFile() {
        try (BufferedReader lukija = new BufferedReader(new FileReader(luettava))) {

            // read all the rows in the file
            for (String rivi = lukija.readLine(); rivi != null; rivi = lukija.readLine()) {

                // String array of all words on a row
                String[] sanat = rivi.split("\\W+");

                // for each word, enter into map or update the count++
                for (String sana : sanat) {
                    if (!sana.isEmpty()) {
                        if (!m.containsKey(sana)) {
                            m.put(sana, 1);
                        } else {
                            int i = m.get(sana) + 1;
                            m.put(sana, i);
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File was not found. Quitting.");
        } catch (IOException e) {
            System.out.println("File was not found. Quitting.");
        }
    }

    static private void printMap(Map map) {

        for (Object s : map.keySet()) {
            System.out.println(map.get((String) s) + " - " + (String) s);
        }

    }

    static private void jarjesta(TreeMap map) {

        List lista = new LinkedList(map.entrySet());

        Collections.sort(lista, new arvonMukaan());
        
        /* EI TOIMI - REDO
        
        Collections.sort(lista, new Comparator(Map.Entry < String, Integer >) {
            public int compare(Map.Entry o1, Map.Entry o2) {

                int arvo1 = (int) o1.getValue();
                int arvo2 = (int) o2.getValue();

                if (arvo1 > arvo2) {
                    return 1;
                } else if (arvo1 < arvo2) {
                    return -1;
                } else {
                    return 0;
                }

            }
        });
        
        */

        Collections.reverse(lista);

        // copy sorted to HashMap jarjestetty
        Iterator it = lista.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            jarjestetty.put((String) entry.getKey(), (Integer) entry.getValue());
        }

    }

    static class arvonMukaan implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            int arvo1 = (Integer) ((Map.Entry)o1).getValue();
            int arvo2 = (Integer) ((Map.Entry)o2).getValue();

            if (arvo1 > arvo2) {
                return 1;
            } else if (arvo1 < arvo2) {
                return -1;
            } else {
                return 0;
            }
        }

    }
}
