package harjoitukset;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class PvmTulostaja {

    // done on Date, DateFormat, NumberFormat & DecimalFormat (pre Java8)
    
    static Locale fi = new Locale("fi", "FI");
    static Locale us = Locale.US;
    static Locale uk = Locale.UK;
    static Locale fr = Locale.FRANCE;
    static Locale jp = Locale.JAPAN;

    public static void main(String[] args) {
        tulostaKielilla();
    }

    private static void tulostaKielilla() {

        int s = DateFormat.SHORT;
        int m = DateFormat.MEDIUM;
        int l = DateFormat.LONG;
        int f = DateFormat.FULL;

        // default Locale date&time, short
        Date pvm = new Date();

        System.out.println("\nDATE & TIME AT DEFAULT LOCALE (" + Locale.getDefault().getDisplayCountry() + "):\n"
                + "Full: " + pvm + "\n"
                + "Shortpvm: " + DateFormat.getDateInstance(s).format(pvm) + "\n"
                + "Shorttime: " + DateFormat.getTimeInstance(s).format(pvm) + "\n"
        );
        
        // dates&times at Locales, full
        datetimeslocs(l, pvm);

        // numbers & currencies
        numberscurrencies();

    }

    private static void datetimeslocs(int f, Date pvm) {

        System.out.println("\nDATES & TIMES AT LOCALES, FULL VERSIONS:\n");

        System.out.println("enUS (" + us.getDisplayCountry() + "):\n"
                + "Fullpvm: " + DateFormat.getDateInstance(f, us).format(pvm) + "\n"
                + "Fulltime: " + DateFormat.getTimeInstance(f, us).format(pvm) + "\n"
        );

        System.out.println("enGB (" + uk.getDisplayCountry() + "):\n"
                + "Fullpvm: " + DateFormat.getDateInstance(f, uk).format(pvm) + "\n"
                + "Fulltime: " + DateFormat.getTimeInstance(f, uk).format(pvm) + "\n"
        );

        System.out.println("fiFI (" + fi.getDisplayCountry() + "):\n"
                + "Fullpvm: " + DateFormat.getDateInstance(f, fi).format(pvm) + "\n"
                + "Fulltime: " + DateFormat.getTimeInstance(f, fi).format(pvm) + "\n"
        );

        System.out.println("frFR (" + fr.getDisplayCountry() + "):\n"
                + "Fullpvm: " + DateFormat.getDateInstance(f, fr).format(pvm) + "\n"
                + "Fulltime: " + DateFormat.getTimeInstance(f, fr).format(pvm) + "\n"
        );

        System.out.println("jpJP (" + jp.getDisplayCountry() + "):\n"
                + "Fullpvm: " + DateFormat.getDateInstance(f, jp).format(pvm) + "\n"
                + "Fulltime: " + DateFormat.getTimeInstance(f, jp).format(pvm) + "\n"
        );

    }

    private static void numberscurrencies() {

        System.out.println("\nNUMBERS & CURRENCIES:\n");

        double pi = 3.1459;
        double minus = -12.3;

        Locale[] locs = {fi, uk, us, Locale.ITALY, Locale.CANADA_FRENCH};

        for (Locale loc : locs) {

            System.out.println(loc + " (" + loc.getDisplayCountry() + "):");

            System.out.println("Currency: "
                    + "\t"
                    + "pi: " + NumberFormat.getCurrencyInstance(loc).format(pi)
                    + "\t"
                    + "minus: " + NumberFormat.getCurrencyInstance(loc).format(minus)
            );

            System.out.println("Number: "
                    + "\t"
                    + "pi: " + NumberFormat.getInstance(loc).format(pi)
                    + "\t"
                    + "minus: " + NumberFormat.getInstance(loc).format(minus)
            );

            NumberFormat max2d = NumberFormat.getInstance(loc);
            if (max2d instanceof DecimalFormat) {
                ((DecimalFormat) max2d).setMaximumFractionDigits(2);
            }

            System.out.println("Number (max2d): "
                    + "pi: " + max2d.format(pi)
                    + "\t"
                    + "minus: " + max2d.format(minus)
            );

            NumberFormat min2d = NumberFormat.getInstance(loc);
            if (min2d instanceof DecimalFormat) {
                ((DecimalFormat) min2d).setMinimumFractionDigits(2);
            }

            System.out.println("Number (min2d): "
                    + "pi: " + min2d.format(pi)
                    + "\t"
                    + "minus: " + min2d.format(minus)
            );

            System.out.println("");
        }

    }
}
