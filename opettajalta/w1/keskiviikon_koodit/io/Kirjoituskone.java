package fi.academy.keskiviikko.io;

import java.io.*;
import java.util.Scanner;

public class Kirjoituskone {
    public static void main(String[] args) {
        try (PrintWriter tiedosto = paperikahva();
             BufferedReader näppis = new BufferedReader(new InputStreamReader(System.in))) {
            if (tiedosto == null) {
                System.out.println("Lopetellaan sitten..");
                System.exit(1);
            }
            System.out.println("Anna tekstiä, tyhjä rivi lopettaa");
            for(String rivi = näppis.readLine() ; !rivi.isEmpty() ; rivi = näppis.readLine()) {
                tiedosto.println(rivi);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Loppu hyvin, kaikki hyvin");
    }

    private static PrintWriter paperikahva() throws IOException {
        String oletus = "paperi.txt";
        Scanner in = new Scanner(System.in);
        System.out.print("Mihin tiedostoon haluat kirjoittaa ["+oletus+"]");
        System.out.flush();
        String nimi = in.nextLine().trim();
        if (nimi.isEmpty())
            nimi = oletus;
        File f = new File(nimi);
        if (f.exists()) {
            System.out.println("Tiedosto on jo olemassa, haluatko korvata? [K/e]");
            String vastaus = in.nextLine().trim();
            if(vastaus.equals("") || vastaus.equalsIgnoreCase("k")) {
                return new PrintWriter(new FileWriter(nimi));
            }
        } else {
            return new PrintWriter(new FileWriter(nimi));
        }
        return null;
    }
}
