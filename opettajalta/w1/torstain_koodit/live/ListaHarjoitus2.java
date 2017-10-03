package fi.academy.torstai.live;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaHarjoitus2 {
    public static String[] nimet = {"Tara", "Catarina", "Riku",
            "Tessa", "Suri", "Sandra", "Robin"};

    public static void main(String[] args) {
        // Uusi luettelo
        Luettelo luettelo = new Luettelo();
        // Katsotaan että tulostus onnistuu
        luettelo.tulostaKaikki();
        // Poistetaan ensimmäinen ja viimeinen nimi luettelosta
        luettelo.poistaPäät();
        // Katsotaan että poistuivat
        luettelo.tulostaKaikki();
        // Kokeillaan etsiä
        System.out.println(luettelo.onkoNimea("Riku"));  // true?
        System.out.println(luettelo.onkoNimea("Tara"));  // false?

        // Esimerkki siitä että jos jäsenmuuttujan palauttaa,
        // niin sen sisältöä voi muuttaa olion ulkopuolella
        luettelo.getLista().clear();
        luettelo.tulostaKaikki();
        luettelo.poistaPäät();
    }
}


// Huom. Ei public class, joten voi sijaita samassa tiedostossa
// kuin ListaHarjoitus2 luokka
class Luettelo {

    private List<String> lista;

    /**
     * Luo listan ja alustaa sen. Listan alustuksessa
     * käytetään <code>ListaHarjoitus2</code>-luokan
     * <code>nimet</code> muuttujaa.
     */
    public Luettelo() {
        this.lista = new ArrayList<>();
        lista.addAll(Arrays.asList(ListaHarjoitus2.nimet));
    }

    /**
     * Luettelon tulostus.
     * Metodi tulostaa tiedon siitä montako nimeä listassa on,
     * sen jälkeen kaikki listan nimet yksi kerrallaan.
     */
    public void tulostaKaikki() {
        System.out.println("\n------------------\n");
        int lkm = lista.size();
        System.out.println("Listalla nimiä: " + lkm);
        for(String nimi : lista) {
            System.out.println(nimi);
        }
        System.out.println("-----------------------\n");
    }

    /**
     * Metodi poistaa ensimmäisen ja viimeisen nimen listasta.
     */
    public void poistaPäät() {
        lista.remove(0);
        lista.remove(lista.size()-1);
    }

    /**
     * Metodilla voi etsiä nimeä listasta.
     *
     * @param nimi Nimi, jota halutaan etsiä
     * @return true jos nimi on listassa, muuten false
     */
    public boolean onkoNimea(String nimi) {
        return lista.contains(nimi);
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }
}
