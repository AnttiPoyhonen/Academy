package greeting;

import org.junit.Test;
import static org.junit.Assert.*;

public class KataGreetingTest {
    
    // fixture object for all tests
    private KataGreeting g = new KataGreeting();
                
    @Test
    public void testBasicGreeting() {   
        assertEquals("Hello, Tommi.", g.greet("Tommi"));
    }
    
    @Test
    public void testNullGreeting() {
        assertEquals("Hello, my little friend.", g.greet(null));
    }
    
    @Test
    public void testShoutGreeting() {
        assertEquals("HELLO, TOMMI!", g.greet("TOMMI"));
    }
    
    @Test
    public void testMultipleGreeting() {
        assertEquals("Hello, Tommi and Ville.", g.greet("Tommi", "Ville"));
        assertEquals("Hello, Mirka, Marko and Milla.", g.greet("Mirka", "Marko", "Milla"));
        assertEquals("Hello, Sakari, Sauli, Santeri and Sanna.", g.greet("Sakari, Sauli", "Santeri, Sanna"));
    }
    
    @Test
    public void testMultipleShoutGreeting() {
        assertEquals("Hello, Mirka, Marko and Milla. AND HELLO, LAURA, LIISA AND LATE!", g.greet("Mirka", "LAURA", "LIISA", "LATE", "Marko", "Milla"));
    }
    
    @Test
    public void testIntentionalMultipleGreeting() {
        assertEquals("Hello, Antero, Alli and Aulis, Aave.", g.greet("Antero", "Alli", "\"Aulis, Aave\""));
    }
            
}
