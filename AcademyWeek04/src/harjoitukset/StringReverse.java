package harjoitukset;

import java.util.Collections;

public class StringReverse {

    private String reversable;
    private String reversed;
    
    public StringReverse (String s) {
        
        this.reversable = s;
        
    }
    
    public StringReverse () {
        
        this.reversable = "";
        
    }

    public String getReversable() {
        return reversable;
    }

    public void setReversable(String reversable) {
        this.reversable = reversable;
    }

    public String getReversed() {
        return reversed;
    }

    public void setReversed(String reversed) {
        this.reversed = reversed;
    }
    
    public String reverse() {
        
        if ("".equals(reversable)) {
            return "There was nothing to reverse; use '.setReversable(String)' to add a new reversable";
        }
        
        char chars [] = this.reversable.toCharArray();
        char charsreversed [] = new char[chars.length];
        
        int charAt = 0;
        
        for (int i = chars.length - 1; i >= 0; i--) {
            charsreversed[charAt] = chars[i];
            charAt++;
        }
        
        reversed = new String(charsreversed);
        
        return reversed;
    }
    
    public String reverse (String s) {
        
        String savedReversable = this.reversable;
        this.reversable = s;
        
        String reversedS = this.reverse();
        
        this.reversable = savedReversable;
        
        return reversedS;
    }
    
}
