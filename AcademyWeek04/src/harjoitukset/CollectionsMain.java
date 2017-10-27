package harjoitukset;

//    13. Yksinkertaisia toimenpiteitä, eli kirjoita koodi. Varmistaa, että muistat List-tyypin
//      metodeita. Tulosta lista kunkin sellaisen kohdan jälkeen missä listan sisältöä
//      muutetaan - tulosta myös mahdollinen vastaus kysymykseen Eli kysymykseen
//      "montako kirjainta?": tulosta kirjainten määrä.

//       Toteuta lista, jossa on kirjaimet 'A'-'Z', mutta merkkijonoina, eli listan
//          sisältö "A", "B", "C", ..., "Z"
//       Montako kirjainta listalla on?
//       Tarkista onko listalla kirjain 'M', monesko kirjain se on?
//       Sekoita listan järjestys, monesko kirjain 'M' on nyt?
//       Lisää kirjaimet 'Å, 'Ä' ja 'Å' listalle seuraavasti: 'Å' ennen kirjainta 'A', 'Ä'
//          kirjaimen 'A' perään ja 'Ö' listan ensimmäiseksi
//       Järjestä lista. Tulosta, tarkista tulostuksesta missä "Å", "Ä" ja "Ö" ovat
//       Miten järjestäisit listan suomalaisittain aakkostettuna? Älä käytä omaa
//          järjestämistä, pelkillä Javan luokkakirjaston luokilla.
//       Poista vokaalit listalta (AEIOUYÄÖ)
//       Tee uusi lista missä on kaikki vokaalit, lisää vokaalit tätä uutta listaa
//          käyttäen alkuperäiseen listaan

//    14. Sanoja tiedostossa: Lue tekstitiedosto ja tulosta löydetyt yksittäiset sanat, 1)
//      aakkosjärjestyksessä 2) sanan pituuden mukaan järjestyksessä
//       Vinkki kohtaan 1): Set
//       Vinkki kohtaan 2): kopioi Set -> Lista, ja sen jälkeen sort() käyttäen
//          sopivaa Comparatoria

//    15. Tee oma järjestäjä, joka vertaa merkkijonoja siten että isoilla ja pienillä merkeillä
//      ei ole väliä. Miten toimii ääkkösillä? Miksi toimii tai ei?

public class CollectionsMain {

    public static void main(String[] args) {
        
        String input = "";

        // LIST METHODS
        System.out.println("LIST METHODS:");

        ListMethods list = new ListMethods();
        
        list.initAlph();
        System.out.println("The initialized list: ---" + list.print());
        System.out.println("The size of the list is: --- " + list.getSize());
        System.out.println("What is the position of: 'M' --- " + list.placement("m"));
        System.out.println("");
        
        list.addAlph('å', "before", 'a');      
        list.addAlph('Ä', "before", "a");   
        list.addAlph("ö", "before", "a");     
        System.out.println("List w/ å scandics: --- " + list.print());
        System.out.println("The size of the list is: --- " + list.getSize());
        System.out.println("");
        
        list.scramble();
        System.out.println("List, scrambled: --- " + list.print());
        System.out.println("The size of the list is: --- " + list.getSize());
        System.out.println("What is the position of: 'M' --- " + list.placement("m"));
        
        list.order();
        System.out.println("List, ordered, 'Ä' at wrong place: --- " + list.print());
        list.collatorOrder();
        System.out.println("List, ordered, 'Ä' at the right place: --- " + list.print());
        System.out.println("");
        
        list.removeAe();
        System.out.println("List, without ae: --- " + list.print());
        System.out.println("The size of the list is: --- " + list.getSize());
        System.out.println("");
        
        ListMethods list2 = new ListMethods();
        list2.initFull();
        ListMethods.combine(list, list2);
        
        System.out.println("Lists, combined: --- " + list.print());
        list.order();
        System.out.println("List, combined, ordered: --- " + list.print());
        System.out.println("");
        
        

        // WORDS IN A FILE



        // COMPARATOR TO IGNORE UPPER/LOWERCASE



    }
}
