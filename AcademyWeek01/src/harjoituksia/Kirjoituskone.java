package harjoituksia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileWriter;

// BufferedReader lukija = new BufferedReader(new InputStreamReader(System.in))
// PrintWriter kirjoittaja = 
//                  new PrintWriter(new Filewriter("file/uusiteksti.txt", true))
//   => kirjoittajan 2. parametrina true, niin append, muuten ylikirjoitus

public class Kirjoituskone {

    static String teksti = null;
    static String kohde = null;

    public static void main(String[] args) {

        // kohde & luettava
        lueKohdeJaSyote();

        // kirjoittaminen
        kirjoita();

    }

    private static void lueKohdeJaSyote() {
        try (BufferedReader lukija = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Mihin haluat lukea? (kohdepolku)");
            kohde = lukija.readLine();

            System.out.println("Mitä haluat lukea?");
            teksti = lukija.readLine();

        } catch (IOException e) {
            System.out.println("Ei kohdetta.");
        }
    }

    private static void kirjoita() {
        try (PrintWriter kirjoittaja = new PrintWriter(new FileWriter(kohde))) {
            System.out.println("\nTiedostoon: " + kohde + "\nLuettua: " + teksti + "\n");
            kirjoittaja.write(teksti);
        } catch (IOException e) {
            System.out.println("Tiedostoon ei voinut kirjoittaa!");
        }
    }

}
