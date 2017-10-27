package harjoitukset;

//  5. Tee metodi, joka tulostaa #1a2b3c tyyppisen CSS värimäärityksen rgb()-
//      muotoisena. Eli #ffffff -> rgb(255, 255, 255) tai #FEA51F -> rgb(254, 165, 31)

//  6. Toteuta luvun alkutekijöiden selvitys. Luvun alkutekijöitä ovat siis ne pienimmät
//      numerot, joilla luvun voi jakaa (https://fi.wikipedia.org/wiki/Alkutekij%C3%A4). Tee
//      metodi List<Integer> tekijat(int luku), joka siis ottaa luvun
//      parametrinaan ja palauttaa kyseisen luvun alkutekijät listassa. Jos kyseessä on
//      alkuluku, niin palauta lista jossa on vain luku itse. Tee myös tarkistus siitä, että
//      tekijöihin jako on onnistunut. Pari esimerkkiä alkutekijöihin jakamisesta:
//       tekijat(12) -> [2, 2, 3], eli 2 * 2 * 3 == 12
//       tekijat(153) -> [3, 3, 17], eli 3 * 3 * 17 == 153
//       tekijat(13) -> [13], eli 13 == 13

//  7. Hieman lisää matematiikkaa: tee metodit, jotka laskevat luvun suurimman
//      yhteisen tekijän ja pienimmän yhteisen jaettavan. Lisätietoa esim.
//      https://matta.hut.fi/matta2/isom/html/alkutekj3.html Varsinkin suurimman yhteisen
//      tekijän laskennassa helpottaa jos olet toteuttanut jo alkutekijöihin jaon.

public class NumeroitaAjatteluaMain {
    
    public static void main(String[] args) {
        
        String input = "";
        
        // RGB VÄRIT, input in form #fff or #ffffff
        RGB rgb = new RGB();
        input = "#ffffff";
        
        System.out.println(input + " to RGB: --- " + rgb.toRGB(input));
        System.out.println("Red, Green, Blue (254, 165, 31) to hex: --- " + rgb.toHex(254, 165, 31));
        
            // TODO back to hex
        
        // LUVUN ALKUTEKIJÄT
        
            //TODO
        
        // SUURIN YHTEINEN TEKIJÄ JA PIENIN YHTEINEN JAETTAVA
        
            //TODO
        
        
                
    }

}
