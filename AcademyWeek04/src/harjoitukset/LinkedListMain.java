package harjoitukset;

//    1. Toteuta kaksi luokkaa: LinkitettyLista, joka toimii rajapintana toteutukselle, sekä
//      Solmu, eli luokka jonka instansseja "linkit" ovat, ja joka myös pitää kirjaa arvosta.

//    2. LinkitettyLista jäsenet:

//        public class LinkitettyLista {
//          private Solmu pää; // Listan alku
//          private Solmu häntä; // Listan loppu
//        }

//    3. Solmu jäsenet:

//        class Solmu {
//          private Solmu edellinen;
//          private Solmu seuraava;
//          private int arvo;
//        }

//    4. Seuraavaksi luokkien toteutus, ja testikoodin kirjoittaminen. Lisää siis projektiin
//      testit LinkitettyLista-luokkaa varten ja varmista että luokka toimii oikein.

//    5. Toteuta nyt luokkaan LinkitettyLista rajapinta, jossa on seuraavat toiminnot
//      (muokkaa luokkaa Solmu tarpeen mukaan). Tee toteutus taas pienissä osissa,
//      älä yritä saada kaikkea toimimaan kerralla.

//       void lisaa(int) ; eli jos teet List interface'in toteutuksen, niin tämä on
//          add(Integer)
//       void lisaaAlkuun(int)
//       int lukumaara()
//       boolean loytyyko(int)
//       int hae(int indeksi)
//       int poista() // poistaa viimeisen
//       int poistaAlusta()
//       void tyhjenna()
//       boolean onkoTyhja()

//    Lisätehtävä - linkitetty lista
//    6. Toteuta myös iteraattori listalle. ListaIterator on siis luokka, jonka avulla voidaan
//      käydä Lista läpi. Käytä tässä rajapintana java.util.Iterator rajapintaa, vaikka olisit
//      tehnyt suomalaisen rajapinnan. Näin voit käyttää myös LinkitettyLista-tyyppistä
//      esimerkiksi forech-tyyppisessä silmukassa suoraan.

//      public class LinkitettyLista {
//          private Solmu pää; // Listan alku
//          private Solmu häntä; // Listan loppu
//      }

//      class Solmu {
//          private Solmu edellinen;
//          private Solmu seuraava;
//          private int arvo;
//      }

//       Toteuta ListaIterator luokan LinkitettyLista sisäluokkana
//       LinkitettyLista palauttaa iterator olion Iterator iterator() metodilla

//    7. Toteuta myös reverseiterator, eli vastaava kuin iterator, mutta se käy listan
//      lopusta alkuun

//    8. Toteuta lisää toiminnallisuutta, esimerkiksi

//       reverse(), joka kääntää listan alkiot
//       montako(int), joka kertoo montako kappaletta parametrina saatua arvoa
//          listalla on
//       jarjesta(), joka järjestää alkiot listalla
//       sum(), joka palauttaa listan alkioiden summan

public class LinkedListMain {

}
