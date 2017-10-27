package harjoitukset;

import java.util.Arrays;
import java.util.Scanner;

public class IsAnagram {

    public void check(){
        
        String a = "", b = "";
        
        try (Scanner in = new Scanner(System.in)) {
            
            System.out.println("What is the first string?");
            a = in.nextLine();
            
            if ("".equals(a)) {
                System.out.println("Nothing checked.");
                return;
            }
            
            System.out.println("What is the second string?");
            b = in.nextLine();
            
            System.out.println("Press ENTER to check if the strings are palindroms.");
            in.nextLine();
            
        }
                
        System.out.println("Are " + a + " and " + b + " anagrams: " + anagramCheck(a, b));
        
    }
    
    private boolean anagramCheck (String a1, String b1) {
                
        String a = a1.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String b = b1.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
                
        if (a.equals(b)) return true;
        if (a.length() != b.length()) return false;                
        
        for (int i = 0; i < a.length(); i++) {
            if (b.indexOf(a.charAt(i)) == -1) {
                return false;
            } else {
              String achar = "" + a.charAt(i);
                b = b.replaceFirst(achar, "");
            }
        }
                        
        return "".equals(b);
        
        /* OR
        
        char [] achars = a.toCharArray();
        char [] bchars = b.toCharArray();
        
        Arrays.sort(achars);
        Arrays.sort(bchars);
        
        return achars.equals(bchars);
        
        */
        
    }
        
}
