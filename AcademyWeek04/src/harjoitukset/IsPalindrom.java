package harjoitukset;

public class IsPalindrom {

    public void check (String s) {
        
        StringReverse sr = new StringReverse();
        
        String toReverse = s.replace(" ", "");
        String reversed = sr.reverse(toReverse);
        
        boolean isPalindrom = toReverse.equalsIgnoreCase(reversed);
        
        System.out.println("Is '" + s + "' a palindrom: " + isPalindrom);
        
    }
}
