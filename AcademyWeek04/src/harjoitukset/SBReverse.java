package harjoitukset;

class SBReverse {

    StringBuilder reverse;
    StringBuilder reversed;
    
    public String reverse (String s) {
        
        reversed = new StringBuilder(s);
        
        reversed.reverse();
        
        return reversed.toString();
    }
    
    public String reverse() {
        
        reversed = new StringBuilder();
        
        for (int i = reverse.length() - 1; i >= 0; i--) {
            reversed.append(reverse.charAt(i));
        }
        
        return reversed.toString();
    }
    
    public SBReverse (String s) {
        this.reverse = new StringBuilder(s);
    }
    
}
