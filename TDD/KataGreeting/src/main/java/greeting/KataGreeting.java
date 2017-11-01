package greeting;

import java.util.ArrayList;
import java.util.List;

public class KataGreeting {

    public String greet(String...nameargs) {
        
        if (nameargs == null) return "Hello, friend.";
        
        List<String> allnames = new ArrayList<>();
        List<String> shoutnames = new ArrayList<>();
        
        for (String name : nameargs) {
            
            if (name == null) {
                allnames.add("friend");
                continue;
            }
                        
            if(name.toUpperCase().equals(name)) {
                shoutnames.add(name);
                continue;
            }
            
            allnames.add(name);
        }
        
        String print = "";
        
        if(allnames.size() > 0) print += printnames(allnames);
        
        if(allnames.size() > 0 && shoutnames.size() > 0) {
            print += " AND " + printnames(shoutnames);
        } else print += printnames(shoutnames);
        
        return print;
    }
    
    private String printnames(List<String> list) {
        
        if (list.size() == 0) return "";
        
        String lastname = null;
        
        if (list.size() > 1) {
            lastname = list.remove(list.size() - 1);
        }
                
        String names = String.join(", ", list);
        
        if (lastname != null) names += " and " + lastname;
        
        String print = "Hello, " + names + ".";
        
        if (list.get(0).toUpperCase().equals(list.get(0))) {
            print = print.toUpperCase();
            if (list.size() > 1) print = print.replace(".", "!");
        }
                
        return print;
                
    }
    
}
