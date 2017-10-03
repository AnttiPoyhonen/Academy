package harjoituksia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class KysymysTesti {

    static List<Kysymys> lista = new ArrayList<>();
    private static final String polku = "file/kysymykset.txt";

    public static void main(String[] args) {
        
        lueTiedosto();

        Collections.shuffle(lista);

        int pisteet = 0;
        int kysytty = 0;
        
        int kysymyksia;
        
        Scanner lue = new Scanner(System.in);
        
        System.out.println("Montako kierrosta haluat pelata? (max " + lista.size() + " kierrosta!)");
        kysymyksia = Integer.parseInt(lue.nextLine());
        System.out.println("Pelataan siis " + kysymyksia + " kierrosta.\n");
        
        for (Kysymys k : lista) {
            
            if (k.kysy()) {
                pisteet++;
            }
            
            kysytty++;
            
            if (kysytty == kysymyksia) {
                System.out.println("Sait " + pisteet + "/" + kysymyksia + " pistettä. Onnittelut!\n");
                break;
            }
        }
    }

    static private void lueTiedosto() {
        try (BufferedReader lukija = new BufferedReader(new FileReader(polku))) {
            // lue kaikki Kysymykset (rivit)
            for (String rivi = lukija.readLine(); rivi != null; rivi = lukija.readLine()) {
                // String array eri elementeistä riviltä
                String[] sanat = rivi.split(",");

                // oikea vastaus int
                int oikea = Integer.parseInt(sanat[4]);
                // lisää uusi Kysymys
                lista.add(new Kysymys(
                        sanat[0], sanat[1], sanat[2], sanat[3], oikea
                ));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found. Quitting.");
        } catch (IOException e) {
            System.out.println("File was not found. Quitting.");
        }
    }
}