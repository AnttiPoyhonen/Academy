package harjoitukset;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SystemProperties {

    public static void main(String[] args) {

        String kotiKansio = System.getProperty("user.home");
        System.out.println(kotiKansio);

        String javaVersion = System.getProperty("java.version");
        System.out.println(javaVersion);
        
        String userName = System.getProperty("user.name");
        System.out.println(userName);
        
        String javaLoc = System.getProperty("java.home");
        System.out.println(javaLoc);
        
        String tempKansio = System.getProperty("java.io.tmpdir");
        System.out.println(tempKansio);
                
        Set<String> props  = System.getProperties().stringPropertyNames();
        
        System.out.println("\nSTRINGPROPERTYNAMES\n");
        for (String p : props) {
            System.out.println(p);
        }
        
        System.out.println("uusi.arvo" + System.getProperty("uusi.arvo"));
        
        Enumeration<String> propsEnum = (Enumeration<String>) System.getProperties().propertyNames();
                
        // using configurations and vm options! -Duser.language=fi
        
        System.out.println("\nENUMPROPERTYNAMES:\n");
        while (propsEnum.hasMoreElements()) {
            String nimi = propsEnum.nextElement();
            System.out.println(nimi + ": \n" + System.getProperty(nimi) + "\n----------------------");
        }
        
        
    }
}
