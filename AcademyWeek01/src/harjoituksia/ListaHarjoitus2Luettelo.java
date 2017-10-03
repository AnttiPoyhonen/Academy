package harjoituksia;

// Huom. Ei public class, joten voi sijaita myös samassa tiedostossa
import java.util.ArrayList;
import java.util.List;

// kuin ListaHarjoitus2 luokka
class Luettelo {

    private List<String> lista;

    /**
     * Luo listan ja alustaa sen. Listan alustuksessa käytetään
     * ListaHarjoitus2-luokan nimet muuttujaa.
     */
    public Luettelo() {
        // TODO: luo lista, esim. ArrayList
        // TODO: Lisää nimet listaan, käytä ListaHarjoitus2.nimet apuna

        lista = new ArrayList<>();

        for (int i = 0; i < ListaHarjoitus2.nimet.length; i++) {
            lista.add(ListaHarjoitus2.nimet[i]);
        }

    }

    /**
     * Luettelon tulostus. Metodi tulostaa tiedon siitä montako nimeä listassa
     * on, sen jälkeen kaikki listan nimet yksi kerrallaan.
     */
    public void tulostaKaikki() {
        // TODO: Tulosta montako nimeä listassa on
        // TODO: Tulosta kaikki nimet listasta

        System.out.println(lista.size());

        for (String s : lista) {
            System.out.println(s);
        }
        
        System.out.println("");
    }

    /**
     * Metodi poistaa ensimmäisen ja viimeisen nimen listasta.
     */
    public void poistaPäät() {
        // TODO: poista listan ensimmäinen alkio
        // TODO: poista listan viimeinen alkio

        lista.remove(0);
        lista.remove(lista.size() - 1);
    }

    /**
     * Metodilla voi etsiä nimeä listasta.
     *
     * @param nimi Nimi, jota halutaan etsiä
     * @return true jos nimi on listassa, muuten false
     */
    public boolean onkoNimea(String nimi) {
        // TODO: Palauta tieto sisältääkö lista parametrina saatavaa nimeä

        if (lista.contains(nimi)) {
            return true;
        }
        return false;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }
}
