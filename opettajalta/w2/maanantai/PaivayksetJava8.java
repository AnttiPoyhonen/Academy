package fi.academy.maanantai;

import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

import static java.time.DayOfWeek.THURSDAY;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.TemporalAdjusters.next;

public class PaivayksetJava8 {

    public static void main(String[] args) {
        LocalDate syntymäpäivä = LocalDate.of(1986, Month.MARCH, 12);
        elinaika(syntymäpäivä);
        päivääJouluun();
        viikonpäivä(LocalDate.of(2017, Month.OCTOBER, 3));

        // Bonus: with-esimerkki
        LocalDate ensiViikonTT = LocalDate.now().plusWeeks(1).with(next(THURSDAY));
        System.out.println("Ensi viikon TT: " + ensiViikonTT);
    }

    private static void elinaika(LocalDate syntymäpäivä) {
        LocalDate tänään = LocalDate.now();

        Period p = Period.between(syntymäpäivä, tänään);
        long p2 = DAYS.between(syntymäpäivä, tänään);
        System.out.println("Olet " + p.getYears() + " vuotta, " + p.getMonths() +
                " kuukautta, ja " + p.getDays() +
                " päivää vanha. (" + p2 + " päivää yhteensä)");
    }

    private static void päivääJouluun() {
        LocalDate tänään = LocalDate.now();
        LocalDate joulu = tänään.withMonth(12).withDayOfMonth(24);

        // Tarkistetaan onko joulu jo ollut tänä vuonna
        if (joulu.isBefore(tänään)) {
            joulu = joulu.plusYears(1);
        }

        Period p = Period.between(tänään, joulu);
        long p2 = DAYS.between(tänään, joulu);
        //long p3 = tänään.until(joulu, DAYS);
        long p3 = Duration.between(tänään.atStartOfDay(),
                                    LocalDateTime.of(joulu, LocalTime.NOON))
                .toDays();
        System.out.println("Jouluun on " + p.getMonths() + " kuukautta ja " +
                p.getDays() + " päivää. (" +
                p2 + " eli " + p3 + " päivää yhteensä)");
    }

    private static void viikonpäivä(LocalDate jokupv) {
        LocalDate tänään = LocalDate.now();
        LocalDate seuraavaJokupv = jokupv.withYear(tänään.getYear());
        if (seuraavaJokupv.isBefore(tänään) || seuraavaJokupv.isEqual(tänään)) {
            seuraavaJokupv = seuraavaJokupv.plusYears(1);
        }
        DayOfWeek dow = seuraavaJokupv.getDayOfWeek();
        System.out.print("Se on: " + dow);
        //<editor-fold desc="//println ja jotain muuta..">
        System.out.println(" ("+dow.getDisplayName(TextStyle.FULL, new Locale("fi"))+")");
        //</editor-fold>
    }
}
