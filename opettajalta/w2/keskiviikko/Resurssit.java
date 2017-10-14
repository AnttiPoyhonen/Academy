package fi.academy.keskiviikko;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Resurssit {

    public static void main(String[] args) {
//        tulosta(Locale.UK);
        Locale[] alueet = new Locale[] {
                Locale.UK,
                new Locale("fi"),
                new Locale("fi", "FI"),
                new Locale("en", "IE"),
                Locale.ITALY};
        for(Locale alue : alueet) {
            tulosta(alue);
        }
    }

    final static Locale SUOMI = new Locale("fi", "FI");
    static LocHenkilo aku = new LocHenkilo();

    private static void tulosta(Locale alue) {
        System.out.println("\n** Käytössä locale: " + alue.getDisplayName(SUOMI));

        // aseta & muotoile tiedot
        String nimi, paiva, palkka;
        nimi = aku.getEtunimi();
        paiva = DateFormat.getDateInstance(DateFormat.MEDIUM, alue).format(aku.getSyntymapaiva());
        palkka = NumberFormat.getCurrencyInstance(alue).format(aku.getPalkka());

        // Resurssien haku
        String nimiteksti, synttariteksti, palkkateksti;
        ResourceBundle nippu
                = ResourceBundle.getBundle("fi.academy.Tekstit", alue);
        System.out.println("** Ladattu nippu alueelta: " + nippu.getLocale());
        nimiteksti = nippu.getString("nimiteksti");
        synttariteksti = nippu.getString("synttariteksti");
        palkkateksti = nippu.getString("palkkakuvaus");

        // Tulostus
        System.out.println(nimiteksti + nimi);
        System.out.println(synttariteksti + paiva);
        // TODO: käytä msg format tulostuksessa
        System.out.println(MessageFormat.format(palkkateksti, palkka));






    }
}
