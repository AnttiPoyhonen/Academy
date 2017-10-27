package harjoitukset;

//    Binaaripuu tarkoittaa tietorakenteena puuta, jossa kullakin solmulla on maksimissaan
//    kaksi lasta. Järjestetty binaaripuu on binaaripuu, joka pitää arvot
//    suuruusjärjestyksessä. Harjoituksessa tehdään puu, joka osaa käsitellä
//    kokonaislukuja.

//    Otetaan esimerkiksi puu, johon lisätään aluksi 'f'.

//    Näin puun koko sisältö on 'f'.

//    Seuraavaksi lisätään 'b', jolloin uusi solmu lisätään puuhun ensimmäisen solmun
//    vasemmalle puolelle - koska 'b' on pienempi kuin 'f'.

//    Lisätään seuraavaksi 'd', lisääminen tapahtuu 'f' solmun vasemmalle puolelle, koska
//    'd' on pienempi kuin 'f', vasen solmu on kuitenkin asetettu, joten katsotaan 'b' arvon
//    pitävää solmua. 'd' on suurempi kuin 'b', joten lisätään uusi solmu 'b' solmun oikealle
//    puolelle.

//    Mikäli lisäämme tällaiseen puuhun arvot (alusta alkaen) 'f', 'b', 'd', 'k', 'c', 'm', 'n', 'l', 'a',
//    niin tuloksena olisi yllä olevan kuvion kaltainen rakenne.

//    Voit toteuttaa puun siten, että et hyväksy duplikaatteja, eli jos yo. puuhun koittaisi
//    lisätä arvon 'b', niin siitä ei tulisi virhettä, mutta puuhun ei vain lisättäisi mitään.
//    Toteuta luokka BinaariPuu ja sille apuluokaksi PuuSolmu. Voit toteutuksessa käyttää
//    java.util.Set rajapintaa pohjana, mutta silloin ohjeen metodien nimet eivät täsmää.
//    Luokkien toteutukset:

//           f
//          / \
//         b   k
//        / \  \
//       a  d   m
//         /  / \
//        c  l   n

//      public class BinaariPuu {
//          private PuuSolmu juuri;
//      }

//      class PuuSolmu {
//          private int arvo;
//          private PuuSolmu vasen;
//          private PuuSolmu oikea;
//      }
//
//    Toteuta puulle aluksi seuraavat metodit, muista testata yksi kerrallaan:

//       void lisaa(int) // lisää uuden alkion puuhun
//       int lukumäärä() // kertoo montako solmua puussa on
//       boolean onko(int) // kertoo onko parametrina saatu arvo puussa
//       void tulosta() // tulostaa kaikki arvot puusta

//    Puiden käsittely tehdään perinteisesti rekursiota käyttäen. Esimerkkinä puun arvojen
//    tulostus pseudokoodilla. Puulla siis public void tulosta() metodi, joka käyttää alla
//    olevan kaltaista private void tulosta(PuuSolmu) apumetodia.

//      tulosta(PuuSolmu solmu):
//      jos solmu.vasen != null: tulosta(vasen)
//      tulosta solmu.arvo
//      jos solmu.oikea != null: tulosta(oikea)

//    Jatka sitten muutamalla muulla toiminnallisuudella, esimerkiksi poista(int), joka
//    poistaa pyydetyn arvon puusta.

public class BinaryMain {

}
