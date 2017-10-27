package harjoitukset;

//    10. Sanoja tiedostossa: lue tiedosto, ja tulosta montako sanaa, pisin sana, lyhyin
//      sana, sanojen pituuden keskiarvo.

//       Avaa tiedosto, ja käy se läpi rivi kerrallaan
//       Rivin saa sanoiksi helpohkosti split() metodilla. Voit käyttää omaa tapaasi
//          pilkkoa rivin, tai esimerkiksi seuraavaa
//          String [] sanat = rivi.split("[\\s\\p{Punct}]+");

//    11. Ensimmäisellä viikolla tehtiin hieman saman tyyppinen sanalaskuri-harjoitus kuin
//      äskeinen harjoitus. Jos sinulla oli silloin sen kanssa ongelmia, niin menisikö se
//      nyt helpommin?

//    12. Toteuta ohjelma, joka vertaa kahta tiedostoa (alkuperäinen, uusi) ja tulostaa
//      niiden erot riveittäin.

//       Aloita vain käymällä kumpaakin tiedostoa läpi rivi kerrallaan ja mikäli rivit
//          eivät ole yhtä suuret, niin tulosta rivit millä erot löytyivät.
//       Jos haluat hieman haastetta, niin niitä saa helposti:

//           i Tulosta mikä riveillä on erona
//          ii Jos rivit eivät ole yhtä suuret, niin katso onko rivi lisätty, tai onko rivi
//              poistettu. Eli käy tiedostoja läpi hieman eteenpäin kunnes löydät
//              taas yhteneväisen rivin.
//          iii Oikein kunnolla haastetta saa, jos yrittää toteuttaa alkuperäisen diff
//              työkalun tyyppisen tulostuksen:

//      https://en.wikipedia.org/wiki/Diff_utility
public class FilesMain {

    public static void main(String[] args) {

        String tiedostopolku = "src/harjoitukset/FilesMain.java";

        // LUE TIEDOSTOSTA SANAT, PISIN, LYHIN, MONTAKO, PITUUDEN KESKIARVO
        TiedostonSanat.sanoja(tiedostopolku);
        
        
        
        // KAHDEN TIEDOSTON VERTAILU, EROT TULOSTETTU RIVEITTÄIN

        
        
        
    }

}
