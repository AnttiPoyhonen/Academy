package fi.academy.torstai;

import java.util.List;
import java.util.Scanner;

public class LuetteloMain {
    private static String menu = "Valitse seuraavista:\n1) Tulosta\n" +
            "2) Lisää\n3) Poista\n4) Muokkaa\n5) Etsi\n0) Lopeta\n";
    private List<Kontakti> lista;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // TODO: Luo ja alusta lista
        while(true) {
            System.out.println(menu);
            String vastaus = in.nextLine();
            switch(vastaus) {
                case "1": tulosta(); break;
                case "2": lisaa(); break;
                case "3": poista(); break;
                case "4": muokkaa(); break;
                case "5": etsi(); break;
                case "0": return;
                default:
                    System.out.println("Tuntematon komento: " + vastaus);
            }
        }
    }
    private static void tulosta() {}
    private static void lisaa() {}
    private static void poista() {}
    private static void muokkaa() {}
    private static void etsi() {}
}
class Kontakti {

}