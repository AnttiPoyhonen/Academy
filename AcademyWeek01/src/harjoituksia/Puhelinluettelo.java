package harjoituksia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Puhelinluettelo {

    private static String menu = "Valitse seuraavista:" 
            + "\n"
            + "1) Näytä luettelo "
            + "2) Näytä luettelo nimen mukaan" 
            + "\n"
            + "3) Lisää " 
            + "4) Poista "
            + "5) Muokkaa " 
            + "6) Etsi" 
            + "\n"
            + "0) Tallenna ja Lopeta"
            + "\n";

    static private List<Kontakti> luettelo;
    static int nextID = 1;
    static StringBuilder nimet = new StringBuilder("");

    static Scanner in = new Scanner(System.in);

    // PuhelinluetteloKontakti(String nimi, String numero)
    public static void main(String[] args) throws ClassNotFoundException {

        // TODO: Luo ja alusta luettelo
        luettelo = new ArrayList<>();

        lueTiedosto();

        while (true) {
            System.out.println(menu);
            String vastaus = in.nextLine();
            switch (vastaus) {
                case "1":
                    tulosta(luettelo);
                    System.out.println("Paina \"Enter\" jatkaaksesi");
                    in.nextLine();
                    break;
                case "2":
                    tulostaNimenMukaan();
                    System.out.println("Paina \"Enter\" jatkaaksesi");
                    in.nextLine();
                    break;
                case "3":
                    lisaa();
                    break;
                case "4":
                    poista();
                    break;
                case "5":
                    muokkaa();
                    break;
                case "6":
                    etsi();
                    break;
                case "0":
                    System.out.println("\nTallennetaan ja lopetetaan.\n");
                    tallennus();
                    in.close();
                    return;
                default:
                    System.out.println("\nTuntematon komento: " + vastaus);
            }
        }
    }

    private static void tulosta(List list) {
        // tulosta kontaktit

        System.out.println("\nPuhelinluettelo:");
        for (Object o : list) {
            Kontakti k = (Kontakti) o;
            System.out.println(k);
        }
        System.out.println("");

    }

    private static void lisaa() {
        // lisää henkilö luettelolle
        System.out.println("\nKenet haluat lisätä? (nimi)");
        String nimi = in.nextLine();
        System.out.println("Mikä on hänen puhelinnumeronsa? (numero)");
        String numero = in.nextLine();
        luettelo.add(new Kontakti(nimi, numero));

        System.out.println("\nLisätty kontakti " + luettelo.get(luettelo.size() - 1) + "\n");

    }

    private static void poista() {
        // poista henkilö luettelolta
        System.out.println("\nKenet haluat poistaa? (nimi)\n[" + nimet + "]");
        String poistettava = in.nextLine();
        for (Kontakti k : luettelo) {
            if (k.getNimi().equals(poistettava)) {
                System.out.println("\nLöydetty kontakti " + k.getNimi() + ", numero "
                        + k.getNumero() + ".\nHaluatko varmasti poistaa yhteystiedon? (k/e)");
                String ke = in.nextLine();
                switch (ke) {
                    case "k":
                        luettelo.remove(k);
                        System.out.println("Kontakti poistettu.\n");
                        return;
                    default:
                        System.out.println("");
                        return;
                }
            }
        }
        System.out.println("Ei löytynyt kyseistä yhteystietoa.\n");
    }

    private static void muokkaa() {
        // muuta henkilön tietoja
        System.out.println("\nKetä haluat muokata? (nimi)");
        String muokattava = in.nextLine();
        for (Kontakti k : luettelo) {
            if (k.getNimi().equals(muokattava)) {
                System.out.println("\nLöydetty kontakti " + k.getNimi() + ", numero "
                        + k.getNumero() + ".\nHaluatko muokata nimeä vai numeroa? "
                        + "(nimi/numero)");
                String n = in.nextLine();
                switch (n) {
                    case "nimi":
                        System.out.print("Syötä uusi nimi: ");
                        String nimi = in.nextLine();
                        k.setNimi(nimi);
                        System.out.println("\nMuokattu kontakti on nyt " + k + "\n");
                        return;
                    case "numero":
                        System.out.print("Syötä uusi numero: ");
                        String numero = in.nextLine();
                        k.setNumero(numero);
                        System.out.println("\nMuokattu kontakti on nyt " + k + "\n");
                        return;
                    case "ID":
                        int ID = Integer.parseInt(in.nextLine());
                        System.out.println("\nMuokattu " + k.ID + " => " + ID + "\n");
                        k.ID = ID;
                        return;
                    default:
                        return;
                }
            }
        }
        System.out.println("Ei löytynyt kyseistä yhteystietoa.\n");

    }

    private static void etsi() {
        // etsi henkilö nimen perusteella
        System.out.println("\nKetä haluat etsiä? (nimi)");
        String etsittava = in.nextLine();
        for (Kontakti k : luettelo) {
            if (k.getNimi().contains(etsittava) || k.getNumero().contains(etsittava)) {
                System.out.println("\nLöydetty kontakti " + k.getNimi() + ", numero "
                        + k.getNumero() + "\n");
                return;
            }
        }
        System.out.println("Valitettavasti kyseistä kontaktia ei löytynyt.\n");
    }

    private static void tulostaNimenMukaan() {
        
        List<Kontakti> luettelo2 = luettelo;
        
        // järjestä nimien mukaan
        Collections.sort(luettelo2);
        
        // tulosta
        tulosta(luettelo2);

    }
    
    private static void tallennus() {

        FileOutputStream tiedostoUlos = null;
        ObjectOutputStream out = null;

        try {
            tiedostoUlos = new FileOutputStream("file/puhelinluettelo.ser");
            out = new ObjectOutputStream(tiedostoUlos);
            out.writeObject(luettelo);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            //close
            try {
                out.close();
                tiedostoUlos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static void lueTiedosto() throws ClassNotFoundException {
        FileInputStream tiedosto = null;
        ObjectInputStream lue = null;

        try {
            // read current file and the latest ID
            tiedosto = new FileInputStream("file/puhelinluettelo.ser");
            lue = new ObjectInputStream(tiedosto);
            luettelo = (List<Kontakti>) lue.readObject();
            
            // lue, mikä on seuraava ID luettelosta
            Kontakti apuK = luettelo.get(luettelo.size() - 1);
            nextID = apuK.getID() + 1;
            
            // kerää nimet luettelosta
            for (Kontakti k : luettelo) {
                nimet.append(k.getNimi());
                nimet.append(", ");
            }
            nimet.deleteCharAt(nimet.length()-1);
            nimet.deleteCharAt(nimet.length()-1);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Ei löydetty puhelinluettelo.txt -tiedostoa, aloitetaan ID:t alusta.");
            nextID = 1;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            //close
            if (tiedosto != null) {
                try {
                    lue.close();
                    tiedosto.close();
                } catch (IOException e) {
                    System.out.println("Ei saatu suljettua sisäänlukua.");
                }
            }
        }

    }
}
