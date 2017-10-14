package fi.academy.keskiviikko;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class KoneenLocalet {
    public static void main(String[] args) {
        eka();
    }
    public static void toka() {
        double palkka = -3.14;
        Locale fi = new Locale("fi", "FI");
        String tulos = "USA: " +
                NumberFormat.getCurrencyInstance(Locale.US).format(palkka);
        tulos += "\nSuomi: " +
                NumberFormat.getCurrencyInstance(fi).format(palkka);
        tulos += "\nUK: " +
                NumberFormat.getCurrencyInstance(Locale.UK).format(palkka);
        System.out.println(tulos);
    }
    public static void eka() {
        Locale oletus = Locale.getDefault();
        Locale suomi = new Locale("fi", "FI");
        System.out.println(oletus.getDisplayName(suomi));
        Locale[] kaikki = Locale.getAvailableLocales();
        Set<String> kielet = new TreeSet<>();
        for (int i = 0; i < kaikki.length ; i++) {
            System.out.print(kaikki[i].getDisplayName(suomi));
            System.out.print("   ");
            System.out.println(NumberFormat.getCurrencyInstance(kaikki[i]).format(-3.14));
            kielet.add(kaikki[i].getDisplayLanguage());
        }
        System.out.println("-------\nLöytyi yhteensä: " + kaikki.length);
        System.out.println("Kieliä: " + kielet.size());
        for(String kieli : kielet) {
            System.out.println(kieli);
        }
    }
}
