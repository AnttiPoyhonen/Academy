package harjoitukset;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class Locales1 {

    public static void main(String[] args) {

        // 1. Koneen default loc
        Locale def = Locale.getDefault();

        System.out.println("SYSTEM DEFAULT LOCALE: " + def);

        System.out.println("Language: " + def.getLanguage());
        System.out.println("DisplayLanguage: " + def.getDisplayLanguage());
        System.out.println("Country: " + def.getCountry());
        System.out.println("DisplayCountry: " + def.getDisplayCountry());

        System.out.println("\n");

        // 2. Koneen kaikki localet
        Locale[] locs = Locale.getAvailableLocales();
        int locCount = 0;

        System.out.println("ALL AVAILABLE LOCALES:\n");
        
        for (Locale loc : locs) {
            System.out.println("Locale: " + loc + ", \t" + loc.getDisplayName());
            locCount++;
        }

        System.out.println("\nTotal locales: " + locCount);
        Set<String> langs = new TreeSet<>();
        
        for (Locale loc : locs) {
            langs.add(loc.getLanguage() + " - " + loc.getDisplayLanguage());
        }
        
        System.out.println("\nTotal languages: " + langs.size() + " languages");
        for (String s : langs) {
            System.out.println(s);
        }
        
        System.out.println("\nDisplay System default Locale in Japanese:");
        System.out.println(def.getDisplayName(Locale.JAPAN));
        
        // 3. => Suomeksi
        Locale suomi = new Locale("fi", "FI");
        System.out.println("\nsuomiLocale: " + suomi);
        System.out.println("Language (Country):\n" + suomi.getDisplayName());
        
    }

}
