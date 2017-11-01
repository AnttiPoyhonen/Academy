package greeting;

import org.junit.Test;
import static org.junit.Assert.*;

public class KataGreetingTest {
    
    // fixture object for all tests
    private KataGreeting g = new KataGreeting();
                
    @Test
    public void testBasicGreeting() {   
        assertEquals("Hello, Tommi.", g.greet("Tommi"));  
        assertEquals("Hello, Kalle.", g.greet("Kalle"));  
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
    public void testMultipleGreeting() {
        assertEquals("Hello, Tommi and Kalle.", g.greet("Tommi", "Kalle"));
    }
    
    
}
