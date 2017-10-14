package harjoitukset;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Currencies {

    public static void main (String[] args) {
        
        DateTimeFormatter m = DateTimeFormatter.ISO_LOCAL_DATE;
        
        // 3.14 in FI, US, UK
        
        double pi = -3.14;
        
        // Suomi - EUR
        Locale fi = new Locale("fi", "FI");
        String piEur = NumberFormat.getCurrencyInstance(fi).format(pi);
        
        // US
        String piDol = NumberFormat.getCurrencyInstance(Locale.US).format(pi);
        
        // UK
        String piPou = NumberFormat.getCurrencyInstance(Locale.UK).format(pi);
        
        System.out.println("Starting number: " + pi);
        System.out.println("FI: " + piEur);
        System.out.println("US: " + piDol);
        System.out.println("UK: " + piPou);
                
    }
    
}
