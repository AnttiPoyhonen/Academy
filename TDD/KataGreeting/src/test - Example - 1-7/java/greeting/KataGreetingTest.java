package greeting;

import org.junit.Test;
import static org.junit.Assert.*;

public class KataGreetingTest {
    
    // fixture object for all tests
    private KataGreeting g = new KataGreeting();
                
    @Test
    public void testBasicGreeting() {   
        assertEquals("Hello, Tommi.", g.greet("Tommi")); 
        assertEquals("Hello, Ville.", g.greet("Ville"));  
    }
    
    @Test
    public void testNullGreeting() {
        assertEquals("Hello, friend.", g.greet(null));
    }
    
    @Test
    public void testShoutGreeting() {
        assertEquals("HELLO, TOMMI!", g.greet("TOMMI"));
    }
    
    @Test
    public void testMultipleGreetings() {
        assertEquals("Hello, Tommi and Ville.", g.greet("Tommi", "Ville"));
        assertEquals("Hello, Ville, Tommi and Liisa.", g.greet("Ville", "Tommi", "Liisa"));
    }
    
    @Test
    public void testMultipleShoutGreetings() {
        assertEquals("Hello, Tommi and Ville. AND HELLO, LIISA, KARLO AND LASSI!", g.greet("Tommi", "LIISA", "KARLO", "LASSI", "Ville"));
    }
    
    @Test
    public void testMultipleInputStringGreeting() {
        assertEquals("Hello, Tommi, Ville and Liisa.", g.greet("Tommi", "Ville, Liisa"));
    }
    
    
}
