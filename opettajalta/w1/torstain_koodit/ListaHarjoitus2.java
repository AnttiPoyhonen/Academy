package fi.academy.torstai;

import java.util.ArrayList;
import java.util.List;

public class ListaHarjoitus2 {
    public static String [] nimet = {"Tara","Catarina","Riku", "Tessa", "Suri", "Sandra", "Robin"};
    public static void main(String[] args) {
        Luettelo luettelo = new Luettelo();
        luettelo.tulostaKaikki();
        luettelo.poistaPäät();
        luettelo.tulostaKaikki();
        if (luettelo.onkoNimea("Riku")) {
            System.out.println("Riku löytyi");
        } else {
            System.out.println("Rikua ei ole");
        }
        if (luettelo.onkoNimea("Tara")) {
            System.out.println("Tara löytyi");
        } else {
            System.out.println("Taraa ei ole");
        }
    }
}

class Luettelo {
    private final List<String> lista;

    /**
     * Luo listan ja alustaa sen. Listan alustuksessa
     * käytetään <code>ListaHarjoitus2</code>-luokan
     * <code>nimet</code> muuttujaa.
     */
    public Luettelo() {
        // luo lista, esim. ArrayList
        lista = new ArrayList<>();
        // lista = new ArrayList<>(Arrays.asList(ListaHarjoitus2.nimet));
        // Lisää nimet listaan
        for(String nimi : ListaHarjoitus2.nimet) {
            lista.add(nimi);
        }
    }

    /**
     * Luettelon tulostus.
     * Metodi tulostaa tiedon siitä montako nimeä listassa on,
     * sen jälkeen kaikki listan nimet yksi kerrallaan.
     */
    public void tulostaKaikki() {
        System.out.println("Nimiä listassa: " + lista.size());
        for (String nimi :
                lista) {
            System.out.println(" - " + nimi);
        }
    }

    /**
     * Metodi poistaa ensimmäisen ja viimeisen nimen listasta.
     * @throws ArrayIndexOutOfBoundsException jos listalla ei ole vähintään kahta nimeä
     */
    public void poistaPäät() throws ArrayIndexOutOfBoundsException{
        lista.remove(0);
        lista.remove(lista.size()-1);
    }

    /**
     * Metodilla voi etsiä nimeä listasta.
     * @param nimi Nimi, jota halutaan etsiä
     * @return <code>true</code> jos nimi on listassa, muuten <code>false</code>
     */
    public boolean onkoNimea(String nimi) {
        return lista.contains(nimi);
    }
}