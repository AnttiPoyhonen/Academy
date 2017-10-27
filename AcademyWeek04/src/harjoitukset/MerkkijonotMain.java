package harjoitukset;

//  1. Tee metodi, joka kääntää annetun merkkijonon.

//  2. Tee metodi palindromi, joka tarkistaa onko parametrina tuleva merkkijono
//      palindromi (eli sana luettuna alusta loppuun, tai lopusta alkuun)
//       Variantit: tarkistus välittämättä pienistä ja suurista kirjaimista, tai
//      välilyönneistä merkkijonon keskellä.

//  3. Tee metodi, joka saa kaksi merkkijonoa parametrinaan ja tarkistaa ovatko ne
//      toistensa anagrammeja. Anagrammi on sanan kirjainten uudelleen ryhmittely,
//      normaalisti joksikin toiseksi järkeväksi sanaksi/sanoiksi
//       https://fi.wikipedia.org/wiki/Anagrammi
//       onkoAnagrammi("lista", "silta") -> true
//       onkoAnagrammi("sisko", "kosi") -> false

//  4. Kontin kielen generaattori ja tulkki. Kontin kieli on leikkikieli, missä jokaisen sanan
//      perään lisätään sana "kontti" ja sen jälkeen käytetään sananmuunnosta näille
//      kahdelle sanalle. Toteuta siis koodi, joka muuntaa normikielestä kontin kieltä, ja
//      taas kontin kielestä takaisin normikieltä.
//       Pari esimerkkiä muunnoksesta:
//      i yksi -> yksi kontti -> koksi yntti
//      ii kaksi -> kaksi kontti -> koksi kantti
//       Lisätietoa tarvittaessa: https://fi.wikipedia.org/wiki/Kontinkieli

public class MerkkijonotMain {
        
    public static void main(String[] args) {
        
        // STRING REVERSAL
        StringReverse reverse = new StringReverse();
        System.out.println("STRING REVERSAL:");
        
        // set a new String to be reversed and reverse
        reverse.setReversable("halabatsuibaa!");
        System.out.println(reverse.reverse());
        
        // straight reverse w/ input
        System.out.println(reverse.reverse("Nonyttoimii!"));
        
        System.out.println("");
        
        
        
        // ISPALINDROM ("saippuakauppias")
        IsPalindrom ip  = new IsPalindrom();
        System.out.println("CHECKING FOR A PALINDROM:");
        
        // palindrom check w/ input
        String input = "saippuakauppias";
        ip.check(input);
        
        // w/ whitespaces and CAPS
        input = "Saippua Kauppias";
        ip.check(input);
        
        // false
        input = "sappaliisa";
        ip.check(input);
        
        System.out.println("");
        
        
        
        // ISANAGRAM (lista <> silta)
        IsAnagram ia = new IsAnagram();
        System.out.println("CHECKING FOR AN ANAGRAM:");
        
        // Anagram check w/ input query
        ia.check();
        
        System.out.println("");
        
        
        
        // KONTIN KIELEN KÄÄNTÄJÄ JA TULKKI
        System.out.println("KONTIN KIELTÄ:");
        KonttiTranslate kt = new KonttiTranslate();
        
        input = "yksi kaksi kolme";
        System.out.println("Käännetään kontin kielelle: " + input);
        System.out.println("Käännös: " + kt.kontiksi(input));
        System.out.println("Takaisin suomeksi: " + kt.suomeksi(kt.kontiksi(input)));
        
        System.out.println("\n'kolojaa Hantti konko ontti komä täntti kot nyntti koikein? ontti' takaisin suomeksi:");
        System.out.println(kt.suomeksi("kolojaa Hantti konko ontti komä täntti kot nyntti koikein? ontti"));
        
        System.out.println("");
        
        
        
        
        
    }
    
}
