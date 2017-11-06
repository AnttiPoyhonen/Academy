package greeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KataGreeting {

    public String greet(String...names) {
        
        String print = "";
        String allnames = "";
        
        List<String> namelist = new ArrayList<>();
        List<String> shoutlist = new ArrayList<>();
        
        if (names == null) return "Hello, my little friend.";
        else {
            
            sortToLists(names, namelist, shoutlist);
            
        }
        
        if (namelist.size() > 0) print += print(namelist);
        if (namelist.size() > 0 && shoutlist.size() > 0) print += " AND ";
        if (shoutlist.size() > 0) print += print(shoutlist);
        
        return print;
        
    }
    
    private static String print(List<String> list) {
        
        String print;
        String allnames = "";
                
        if (list.size() == 1) {

            allnames = list.get(0);

        } else {

            String lastname = list.remove(list.size() - 1);

            allnames += String.join(", ", list);

            allnames += " and " + lastname;

        }
        
        print = "Hello, " + allnames + ".";
        
        if (list.get(0).toUpperCase().equals(list.get(0))) print = print.toUpperCase().replace(".", "!");
        
        return print;
        
    }

    private void sortToLists(String[] names, List<String> namelist, List<String> shoutlist) {
                    
            for (String name : names) {
                
                if (name.charAt(0) == '"' && name.charAt(name.length() - 1) == '"') {
                    
                    add(name.replace("\"", ""), namelist, shoutlist);
                    
                } else if (name.contains(",")) {
                    
                    String[] morenames = name.replace(" ", "").split(",");
                    
                    sortToLists(morenames, namelist, shoutlist);
                    
                } else add(name, namelist, shoutlist);
                
            }
            
    }

    private void add(String name, List<String> namelist, List<String> shoutlist) {
        
        if (name.toUpperCase().equals(name)) {
            shoutlist.add(name);
        } else {
            namelist.add(name);
        }
         
    }
    
}
