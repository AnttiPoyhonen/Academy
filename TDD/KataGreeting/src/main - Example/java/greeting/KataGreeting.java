package greeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KataGreeting {

    public String greet(String...names) {
                
        String print = "";
        List<String> namelist = new ArrayList<>(), shoutlist = new ArrayList<>();
        
        if (names == null) return "Hello, friend.";
        
        for (String name : names) {            
            breakdown(namelist, shoutlist, name);
        }
        
        print += addNamelist(print, namelist);
        print += addNamelist(print, shoutlist);
        
        return print;
        
    }
    
    private String addNamelist(String s, List<String> list) {
        
        if (list.size() == 0) return "";
        
        String print, allnames, lastname;
        
        if (list.size() == 1) allnames = list.get(0);
        else {
            lastname = list.remove(list.size() - 1);
            allnames = String.join(", ", list) + " and " + lastname;            
        }

        print = "Hello, " + allnames + ".";
        
        if (!"".equals(s)) print = " and " + print;
        
        if (list.get(0).toUpperCase().equals(list.get(0))) {
            print = print.toUpperCase().replace(".", "!");
        }
                
        return print;
        
    }

    private void breakdown(List<String> namelist, List<String> shoutlist, String s) {
        
        String[] names = s.split(",");
        
        for (String name : names) {
            
            name = name.trim();
            
            if (name.toUpperCase().equals(name)) shoutlist.add(name);
            else namelist.add(name);            
        }
    }
    
}
