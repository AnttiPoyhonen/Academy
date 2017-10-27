package harjoitukset;

//    8. Toteuta aiemmin esitelty String kaanna(String) metodi, joka kääntää merkkijonon
//      väärinpäin. Tee siitä kaksi StringBuilderia käyttävää versiota:

//       Tee kuten merkkijonoilla, merkki kerrallaan, mutta rakenna uusi
//          merkkijono StringBuilderiä käyttäen
//       Käytä StringBuilderin omaa toiminnallisuutta apuna (älä siis käy
//          merkkijonoa läpi merkki kerrallaan)

//    9. Toteuta ASCII taidetta käyttävä numeron tulostaja, joka siis käyttää hieman
//      suurempaa "fonttia" numeron tulostamiseen. Voit käyttää valmiita esimerkkejä
//      numeroina, esimerkiksi https://gist.github.com/yuanqing/ffa2244bd134f911d365.
//      Toteutus kannattanee tehdä siten, että kukin kirjain on taulukko jonka alkiona on
//      yksi kyseisen numeron tulostettava rivi. Esim.

//      String [] yksi = {"1111 ", " 11 ", " 11 ", " 11 ", "111111"};

//       Tee sitten tulostus siten, että tulostat aina yhden rivin kerrallaan; eli
//          kaikkien numeroiden ensimmäinen rivi + rivinvaihto + kaikkien
//          numeroiden toinen rivi + rivinvaihto jne.
//       Käytä siis StringBuilderia koko viiden rivin merkkijonon kasaamiseen, ja
//          tulosta lopuksi koko tulos.

public class StringBuilderMain {
        
    public static void main(String[] args) {

        String input = "";

        // STRINGBUILDER REVERSE
        System.out.println("STRINGBUILDER REVERSING:");
        input = "tämä käännetään";
        
        SBReverse sbr = new SBReverse("merkkimerkiltä!");
        System.out.println("Käännös merkki merkiltä: " + sbr.reverse());
        System.out.println("Käännös inputista toiminnallisuudella: " + sbr.reverse(input));
        
        System.out.println("");
        

        // ASCII ART NUMBER PRINTING
        System.out.println("ASCRII ART NUMBER PRINTING:");
        
        ASCIINr nr = new ASCIINr();
        nr.printNumber("425214134");
        nr.printNumber(1159433);

        
    }
    
}
