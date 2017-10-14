package fi.academy.keskiviikko;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import static java.text.DateFormat.*;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class PvmTulostaja {
    public static void main(String[] args) {
        tulostaKielillä();
        tulostaKielillä8();
        tulostaNumerot();
    }

    private static void tulostaKielillä() {
        String viivat = "--------------------------------------";
        Date tänään = new Date();
        DateFormat df;
        Locale suomi = new Locale("fi", "FI");
        Locale[] alueet = new Locale[] {Locale.US, Locale.UK, suomi, new Locale("sv", "SE"), Locale.FRANCE, Locale.JAPAN};
        System.out.println("DateInstance, DateFormat.FULL\n"+viivat);
        for(Locale loc : alueet) {
            df = DateFormat.getDateInstance(DateFormat.FULL, loc);
            String pvmstr = df.format(tänään);
            System.out.println(String.format("%s: %s", loc.getDisplayName(suomi), pvmstr));
        }
        System.out.println(String.format("%s\nDateTimeInstance, MEDIUM, LONG\n%s", viivat, viivat));
        for(Locale loc : alueet) {
            df = DateFormat.getDateTimeInstance(MEDIUM, LONG, loc);
            String pvmstr = df.format(tänään);
            System.out.println(String.format("%s: %s", loc.getDisplayName(suomi), pvmstr));
        }
    }

    private static void tulostaKielillä8() {
        String viivat = "--------------------------------------";
        LocalDateTime nyt = LocalDateTime.now();
        LocalDate tänään = nyt.toLocalDate();
        DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        Locale suomi = new Locale("fi", "FI");
        Locale[] alueet = new Locale[] {Locale.US, Locale.UK, suomi, new Locale("sv", "SE"), Locale.FRANCE, Locale.JAPAN};
        System.out.println("LocalDate, FormatStyle.FULL\n"+viivat);
        for(Locale loc : alueet) {
            String pvmstr = df.withLocale(loc).format(tänään);
            System.out.println(String.format("%s: %s", loc.getDisplayName(suomi), pvmstr));
        }
        System.out.println(String.format("\n%s\nLocalDateTime, MEDIUM, SHORT\n%s", viivat, viivat));
        for(Locale loc : alueet) {
            String pvmstr = dtf.withLocale(loc).format(nyt);
            System.out.println(String.format("%s: %s", loc.getDisplayName(suomi), pvmstr));
        }
    }

    private static void tulostaNumerot() {
        String viivat = "--------------------------------------";
        double n1=3.14594, n2=-12.3, n3=12345.6789;
        Locale suomi = new Locale("fi", "FI");
        Locale[] alueet = new Locale[] {suomi, Locale.US, Locale.UK, Locale.ITALY, Locale.CANADA_FRENCH};
        NumberFormat nf;

        System.out.println(String.format("%s\nNumerot\n%s", viivat, viivat));
        for(Locale loc : alueet) {
            nf = NumberFormat.getInstance(loc);
            System.out.println(String.format("%-30s %s \t %s \t %s", loc.getDisplayName(suomi),
                    nf.format(n1), nf.format(n2), nf.format(n3)));
        }
        System.out.println(String.format("%s\nMax 2 desim\n%s", viivat, viivat));
        for(Locale loc : alueet) {
            nf = NumberFormat.getInstance(loc);
            nf.setMaximumFractionDigits(2);
            System.out.println(String.format("%-30s %s \t %s \t %s", loc.getDisplayName(suomi),
                    nf.format(n1), nf.format(n2), nf.format(n3)));
        }
        System.out.println(String.format("%s\nMin 2 desim\n%s", viivat, viivat));
        for(Locale loc : alueet) {
            nf = NumberFormat.getInstance(loc);
            nf.setMinimumFractionDigits(2);
            System.out.println(String.format("%-30s %s \t %s \t %s", loc.getDisplayName(suomi), nf.format(n1), nf.format(n2), nf.format(n3)));
        }
        System.out.println(String.format("%s\nValuutta\n%s", viivat, viivat));
        for(Locale loc : alueet) {
            nf = NumberFormat.getCurrencyInstance(loc);
            System.out.println(String.format("%-30s %s \t %s \t %s", loc.getDisplayName(suomi), nf.format(n1), nf.format(n2), nf.format(n3)));
        }
    }


}
