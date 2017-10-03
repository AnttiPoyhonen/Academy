package harjoituksia;

// Huom. Ei public class, joten voi sijaita myös samassa tiedostossa
import fi.academy.LaitonIkaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// kuin ListaHarjoitus2 luokka
class HenkiloLuettelo {

    private List<Henkilo> lista;

    /**
     * Luo listan ja alustaa sen. Listan alustuksessa käytetään
     * ListaHarjoitus2-luokan nimet muuttujaa.
     */
    public HenkiloLuettelo() throws LaitonIkaException {
        // luo lista, esim. ArrayList
        // Lisää nimet listaan, käytä ListaHarjoitus2.nimet apuna

        lista = new ArrayList<>();

        Henkilo[]hlot = {
                new Henkilo("John", "Doe", 21),
                new Henkilo("Jane", "Doe", 28),
                new Henkilo("Steven", "Tyler", 55),
                new Henkilo("Matt", "Mulligan", 21),
                new Henkilo("James", "Gosling", 55)
        };
        
        // Lisää nimet listaan
        lista = new ArrayList<>(Arrays.asList(hlot));

    }

    /**
     * Luettelon tulostus. Metodi tulostaa tiedon siitä montako nimeä listassa
     * on, sen jälkeen kaikki listan nimet yksi kerrallaan.
     */
    public void tulostaKaikki() {
        // Tulosta montako nimeä listassa on
        // Tulosta kaikki nimet listasta

        System.out.println("Listalla on "  + lista.size() + " henkilöä.");

        for (Henkilo h : lista) {
            System.out.println(h);
        }
        
        System.out.println("");
    }

    /**
     * Metodi poistaa ensimmäisen ja viimeisen nimen listasta.
     */
    public void poistaPäät() {
        // poista listan ensimmäinen alkio
        // poista listan viimeinen alkio

        lista.remove(0);
        lista.remove(lista.size() - 1);
    }

    /**
     * Metodilla voi etsiä nimeä listasta.
     *
     * @param nimi Nimi, jota halutaan etsiä
     * @return true jos nimi on listassa, muuten false
     */
    public boolean onkoNimea(Henkilo hlo) {
        // Palauta tieto sisältääkö lista parametrina saatavaa nimeä

        if (lista.contains(hlo)) return true; else return false;
    }

    public List<Henkilo> getLista() {
        return lista;
    }

    public void setLista(List<Henkilo> lista) {
        this.lista = lista;
    }
    
    public void jarjestaNimi() {
        Collections.sort(lista, new Comparator() {
           public int compare(Object o1, Object o2) {
               Henkilo h1 = (Henkilo) o1;
               Henkilo h2 = (Henkilo) o2;
               return h1.getEtunimi().compareTo(h2.getEtunimi());
           } 
        });
    }
    
    public void jarjestaID() {
        Collections.sort(lista, new IDmukaan());
    }
               
    class IDmukaan implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
               Henkilo h1 = (Henkilo) o1;
               int ID1 = h1.getID();
               Henkilo h2 = (Henkilo) o2;
               int ID2 = h2.getID();
               
               if (ID1 > ID2) {
                   return 1;
               } else if (ID1 < ID2) {
                   return -1;
               } else {
                   return 0;
               }               
       }         
    }
    
}