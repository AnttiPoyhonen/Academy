package fi.academy;

import harjoituksia.Henkilo;

public class HenkiloTesti {

    public static void main(String[] args) {
        
        String a = "Deer";  // testataan null-arvolla
        
        try {
            
            Henkilo[] hlot = {
                new Henkilo("John", "Doe", 21),
                new Henkilo("Jane", "Doe", 28),
                new Henkilo("John", a, 55),
                new Henkilo("John", "Deere", 21),
                new Henkilo("James", "Gosling", 120)}
                    ;
            
            for(Henkilo h : hlot) {            
                System.out.println(h);
            }
            
            Henkilo john = new Henkilo("John", "Doe", 21);
            
            System.out.println(hlot[0] == john); // false
            System.out.println(hlot[0].equals(john)); // true
            
        } catch (LaitonIkaException | NullPointerException ex) {
            System.out.println("Ran into an error " + ex.getMessage());
            System.err.println(ex.getMessage());
        }
    }

}
