package harjoitukset;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import static java.time.temporal.ChronoUnit.DAYS;

public class LocalDates {
    
    public static void main (String[] args) {
        
        System.out.println("SYNTYMÄPÄIVÄT:");
        // aikaa juhliin 2.12.2017
        LocalDate nyt = LocalDate.now();
        LocalDate party = LocalDate.of(2017, 12, 02);
        LocalDate syntynyt = LocalDate.parse("1986-12-02");
                
        Period juhliin = Period.between(nyt, party);
        
        System.out.println(juhliin.getYears() + " vuotta, " 
                + juhliin.getMonths() + " kuukautta ja " 
                + juhliin.getDays() + " päivää juhliin!");
        
        Period ika = Period.between(syntynyt, nyt);
        
        System.out.println("Olen syntynyt " + ika.getYears() + " vuotta, " 
                + ika.getMonths() + " kuukautta ja " 
                + ika.getDays() + " päivää sitten.");
        
        long ikaPaivia = DAYS.between(syntynyt, nyt);
        
        System.out.println("Olen siis syntynyt " + ikaPaivia + " päivää sitten.");
        
        
        System.out.println("\nJOULUUN:");
        
        LocalDate tanaan = LocalDate.now();
        LocalDate joulu = tanaan.withMonth(12).withDayOfMonth(24);
        
        if(joulu.isBefore(tanaan)) {
            joulu = joulu.plusYears(1);
        }
        
        long jouluun = DAYS.between(tanaan, joulu);
        
        System.out.println("Jouluun on enää " + jouluun + " päivää!");
        
        
        System.out.println("\nVIIKONPÄIVÄSTÄ:");
        LocalDate synttarit = syntynyt.withYear(2017);
        
        long synttareihin = DAYS.between(nyt, synttarit);
        
        System.out.println("Syntymäpäivään on " + synttareihin + " päivää.");
        
        DayOfWeek viikonpaiva = synttarit.getDayOfWeek();
        
        System.out.println("Syntymäpäivä on viikonpäivänä " + viikonpaiva);
        
        
    }
    
}
