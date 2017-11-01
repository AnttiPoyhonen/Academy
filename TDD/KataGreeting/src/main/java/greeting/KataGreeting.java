package greeting;

import java.util.Arrays;
import java.util.List;

public class KataGreeting {

    public String greet(String...names) {
        
        String print;
        String printname;
        String lastname;
        
        if (names == null) printname = "friend";
        else {
                
            List<String> allnames = Arrays.asList(names);
                
            lastname = allnames.remove(allnames.size() - 1);
            
            printname = String.join(", ", allnames) + " and " + lastname;
        }
        
        print = "Hello, " + printname + ".";
        
        if (printname.toUpperCase().equals(printname)) {
            print = print.toUpperCase().replace(".", "!");
        }
        
        return print;
        
    }
    
}
