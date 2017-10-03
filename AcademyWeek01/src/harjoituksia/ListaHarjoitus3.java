package harjoituksia;

import fi.academy.LaitonIkaException;

public class ListaHarjoitus3 {
    
    public static void main(String[] args) {

        try {

            // Uusi luettelo
            HenkiloLuettelo luettelo = new HenkiloLuettelo();

            // Katsotaan että tulostus onnistuu
            luettelo.tulostaKaikki();

            // Poistetaan ensimmäinen ja viimeinen nimi luettelosta
            luettelo.poistaPäät();

            // Katsotaan että poistuivat
            luettelo.tulostaKaikki();

            // Kokeillaan etsiä
            Henkilo hlo = new Henkilo("Steven", "Tyler", 55);
            if (luettelo.onkoNimea(hlo)) {
                System.out.println(hlo + " löytyi\n");
            } else {
                System.out.println(hlo + " ei löydy\n");
            }

            /*
            // Esimerkki siitä että jos jäsenmuuttujan palauttaa,
            // niin sen sisältöä voi muuttaa olion ulkopuolella
            luettelo.getLista().clear();
            luettelo.tulostaKaikki();
            */
            
            luettelo.jarjestaNimi();
            luettelo.tulostaKaikki();
            
            luettelo.jarjestaID();
            luettelo.tulostaKaikki();

        } catch (LaitonIkaException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /* sisäluokka, nimetön sisäluokka ja Comparator
    
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
    
    */
    
}
