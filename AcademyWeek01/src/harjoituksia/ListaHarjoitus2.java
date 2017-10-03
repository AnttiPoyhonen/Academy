package harjoituksia;

import java.util.ArrayList;
import java.util.List;

public class ListaHarjoitus2 {

    public static String[] nimet = {"Tara", "Catarina", "Riku",
        "Tessa", "Suri", "Sandra", "Robin"};

    public static void main(String[] args) {
        
        // Uusi luettelo
        Luettelo luettelo = new Luettelo();
        
        // Katsotaan että tulostus onnistuu
        luettelo.tulostaKaikki();
        
        // Poistetaan ensimmäinen ja viimeinen nimi luettelosta
        luettelo.poistaPäät();
        
        // Katsotaan että poistuivat
        luettelo.tulostaKaikki();
        
        // Kokeillaan etsiä
        System.out.println(luettelo.onkoNimea("Riku")); // true?
        System.out.println(luettelo.onkoNimea("Tara")); // false?
        
        // Esimerkki siitä että jos jäsenmuuttujan palauttaa,
        // niin sen sisältöä voi muuttaa olion ulkopuolella
        luettelo.getLista().clear();
        luettelo.tulostaKaikki();
    }
}
