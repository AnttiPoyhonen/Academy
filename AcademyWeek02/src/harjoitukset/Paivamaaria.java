package harjoitukset;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Paivamaaria {

    public static void main (String[] args) {
        
        System.out.println("DATES NOW:");
        
        //Date
        Date nyt1 = new Date();
        
        System.out.println("Date: " + nyt1);
                
        //Calendar
        Calendar nyt2 = new GregorianCalendar(2017, 9, 2);
        
        System.out.println("Calendar: " + nyt2);
        
        //LocalDate
        LocalDate nyt3 = LocalDate.parse("2017-10-02");
        
        System.out.println("LocalDate: " + nyt3);
        
        //LocalDateTime
        LocalDateTime nyt4 = LocalDateTime.now();
        
        System.out.println("LocalDateTime: " + nyt4);
        
        System.out.println("\nDATE FORMATTINGS:");
        
        //Calendar to Date
        Calendar jan1st = new GregorianCalendar(2017, Calendar.JANUARY, 1);
        Date jan1stDate = jan1st.getTime();
        System.out.println("CalToDate (January 1st): " + jan1stDate);
        
        //LocalDate to Date
        LocalDate christmas = LocalDate.of(2017, 12, 24);
        Date christmasDate = Date
                .from(christmas.atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                        .toInstant());
        System.out.println("LocalDateToDate (Christmas): " + christmasDate);
       
    }
    
}
