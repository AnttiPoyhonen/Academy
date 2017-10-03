package FiAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kukkaparsin {

    private static String katenoitu = null;
    private static String bufferoitu = null;
    private static String bufferoitu2 = null;

    public static void main(String[] args) throws FileNotFoundException {
        
        System.out.println(String.format("Katenointi: %.4fms", merkkijonokatenointi() / 1000_000.0));
        System.out.println(String.format("Puskurointi: %.4fms", merkkijonopuskurointi() / 1000_000.0));
        System.out.println(String.format("StringBuffer: %.4fms", merkkijonopuskurointi2() / 1000_000.0));
        
        System.out.println("\n Stringit:"
            + "\nKatenoitu: " + katenoitu
            + "\nPuskuroitu: " + bufferoitu
            + "\nPuskuroitu (StringBuffer): " + bufferoitu2
            + "\n\nOlivatko Stringit samat? " + katenoitu.equals(bufferoitu));
    }

    private static long merkkijonokatenointi() throws FileNotFoundException {
        long kesto = -1;
        katenoitu = "";
        try (Lukija lukija = new Lukija()) {
            long alku = System.nanoTime();
            for (String s = lukija.next(); s != null; s = lukija.next()) {
                katenoitu += s;
            }
            long loppu = System.nanoTime();
            kesto = loppu - alku;
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
            long loppu = System.nanoTime();
            kesto = loppu - alku;
            bufferoitu = tulos.toString();
        }
        return kesto;
    }
    
    private static long merkkijonopuskurointi2() throws FileNotFoundException {
        long kesto = -1;
        StringBuffer tulos = new StringBuffer();
        try (Lukija lukija = new Lukija()) {
            long alku = System.nanoTime();
            for (String s = lukija.next(); s != null; s = lukija.next()) {
                tulos.append(s);
            }
            long loppu = System.nanoTime();
            kesto = loppu - alku;
            bufferoitu2 = tulos.toString();
        }
        return kesto;
    }

}

class Lukija implements AutoCloseable {

    private final static String TIEDOSTO = "file/flowersofevil.txt";
    private Scanner scanner;

    public Lukija() throws FileNotFoundException {
        scanner = new Scanner(new FileInputStream(TIEDOSTO));
    }

    @Override
    public void close() throws RuntimeException {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    public String next() {
        scanner.useDelimiter("[\\s\\p{Punct}]+");
        if (scanner.hasNext()) {
            String sana = scanner.next();
            return sana;
        } else {
            return null;
        }
    }
}
