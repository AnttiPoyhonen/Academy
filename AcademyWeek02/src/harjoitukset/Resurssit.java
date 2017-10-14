package harjoitukset;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class Resurssit {

    private static GregorianCalendar syntg = new GregorianCalendar(1988, Calendar.FEBRUARY, 14);
    private static Date synt = syntg.getTime();
    private static String polku = "harjoitukset/ResourceBundle/Tekstit";

    private static LocHenkilo h = new LocHenkilo("Ville", "Nurminen", synt, 2500);

    private static Locale[] locs = {
        Locale.UK,
        new Locale("sv", "SE"),
        new Locale("fi", "FI"),
        new Locale("en", "IE"),
        Locale.ITALY
    };

    private static ResourceBundle rb;

    public static void main(String[] args) {

        for (Locale loc : locs) {
            tulosta(loc);
        }

    }

    public static void tulosta(Locale loc) {

        rb = ResourceBundle.getBundle(polku, loc);

        String nimi = h.getEtunimi() + " " + h.getSukunimi();

        Date d = h.getSyntymapaiva();

        String paiva = String.valueOf(d.getDate()) + "."
                + String.valueOf(d.getMonth()) + "."
                + String.valueOf(d.getYear());

        String palkka = String.valueOf(h.getPalkka());

        System.out.println("Tulostus Locale: " + loc.getDisplayLanguage()
                + " - " + loc.getDisplayCountry());

        System.out.println(rb.getString("nimikuvaus") + " " + nimi);
        System.out.println(rb.getString("synttarikuvaus") + " " + paiva);

        MessageFormat p = new MessageFormat(rb.getString("palkkakuvaus"));
        Object[] arg = {palkka};

        System.out.println(p.format(arg));

        System.out.println("");

    }

}
