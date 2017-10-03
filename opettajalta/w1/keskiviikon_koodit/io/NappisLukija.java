package fi.academy.keskiviikko.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NappisLukija {
    public static void main(String[] args) {
        String rivi = null;
        try (BufferedReader lukija =
                new BufferedReader(new InputStreamReader(System.in))) {
            rivi = lukija.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Annoit: " + rivi);
    }

    private static void foo() {
        String rivi;
        BufferedReader lukija = null;
        try  {
            lukija =
                    new BufferedReader(new InputStreamReader(System.in));
            rivi = lukija.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (lukija != null)
                try {
                    lukija.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}
