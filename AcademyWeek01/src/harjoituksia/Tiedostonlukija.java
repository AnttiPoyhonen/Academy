package harjoituksia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Tiedostonlukija {

    public static void main(String[] args) {

        Tiedostonlukija o = new Tiedostonlukija();

        try (Scanner in = new Scanner(System.in)) {

            outer:
            for (;;) {

                String polku = null;

                System.out.println("\nMikä tiedosto avataan (anna polku):");

                polku = in.nextLine();

                try {
                    o.lueTiedosto(polku);
                } catch (IOException e) {
                    System.out.println("Tiedostoa ei löytynyt!\n");
                }

                System.out.println("Jatketaanko? (k/e)");

                inner:
                for (;;) {

                    String valinta;
                    valinta = in.nextLine();
                    switch (valinta) {
                        case "k":
                            break inner;
                        case "e":
                            break outer;
                        default:
                            System.out.println("Epäkelpo valinta.");
                            break;
                    }

                }

            }

        } catch (NoSuchElementException e) {
            System.out.println("Mitään ei syötetty!");
        }
        
        System.out.println("\nLopetetaan.");
    }

    public void lueTiedosto(String n) throws IOException {
        // lukee tiedoston sisällön ja tulostaa konsoliin
        // parametri on luettavan tiedoston nimi
        // "file/teksti1.txt"

        String tuloste;

        FileReader reader = new FileReader(n);
        BufferedReader input = new BufferedReader(reader);

        StringBuilder print = new StringBuilder();

        while (input.ready()) {
            print.append(input.readLine()).append("\n");
        }

        tuloste = print.toString();

        System.out.println("\n" + tuloste);

        reader.close();
        input.close();

    }

}
