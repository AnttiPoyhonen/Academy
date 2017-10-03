package fi.academy.keskiviikko.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tiedostonlukija {
    public static void main(String[] args) {
        Tiedostonlukija tiedostonlukija = new Tiedostonlukija();
        tiedostonlukija.lueTiedosto("tiedosto.txt");
        tiedostonlukija.lueTiedosto("src/fi/academy/keskiviikko/io/Tiedostonlukija.java");
        tiedostonlukija.lueTiedosto("TätäEi.Ole");
    }

    private void lueTiedosto(String nimi) {
        try (FileReader fr = new FileReader(nimi);
             BufferedReader lukija = new BufferedReader(fr)) {
            System.out.println(String.format("==== %s ======\n", nimi));
            String rivi = lukija.readLine();
            int i = 1;
            while(rivi != null) {
                System.out.println(i+++": "+rivi);
                rivi = lukija.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei ole!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("===============================\n");

    }
}
