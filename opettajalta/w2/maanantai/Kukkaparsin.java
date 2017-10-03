package fi.academy.maanantai;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kukkaparsin {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(String.format("Katenointi: %.4fms", merkkijonokatenointi() / 1000_000.0));
        System.out.println(String.format("Rakentaminen: %.4fms", merkkijonopuskurointi() / 1000_000.0));
    }

    private static long merkkijonokatenointi() throws FileNotFoundException {
        long kesto = -1;
        String tulos = "";
        try (Lukija lukija = new Lukija()) {
            long alku = System.nanoTime();
            for (String s = lukija.next(); s != null; s = lukija.next()) {
                tulos += s;
            }
            long loppu = System.nanoTime();
            kesto = loppu - alku;
            System.out.println(tulos);  // luettu merkkijono
        }
        return kesto;
    }
    private static long merkkijonopuskurointi() throws FileNotFoundException {
        long kesto = -1;
        StringBuilder tulos = new StringBuilder();
        try (Lukija lukija = new Lukija()) {
            long alku = System.nanoTime();
            for (String s = lukija.next(); s != null; s = lukija.next()) {
                tulos.append(s);
            }
            String ulos = tulos.toString();
            long loppu = System.nanoTime();
            kesto = loppu - alku;
            System.out.println(ulos);  // luettu merkkijono
        }
        return kesto;
    }
}

class Lukija implements AutoCloseable {
    private final static String TIEDOSTO = "flowersofevil.txt";
    private Scanner scanner;

    public Lukija() throws FileNotFoundException {
        scanner = new Scanner(new FileInputStream(TIEDOSTO));
    }

    @Override
    public void close() throws RuntimeException {
        if(scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    public String next() {
        scanner.useDelimiter("[\\s\\p{Punct}]+");
        if (scanner.hasNext()) {
            String sana = scanner.next();
            return sana;
        }
        else
            return null;
    }
}