package greeting;

import org.junit.Test;
import static org.junit.Assert.*;

public class KataGreetingTest {
    
    // fixture object for all tests
    private KataGreeting g = new KataGreeting();
                
    @Test
    public void testBasicGreeting() {   
        assertEquals("Hello, Tommi.", g.greet("Tommi"));   
        assertEquals("Hello, Samu.", g.greet("Samu"));      
    }
               
    @Test
    public void testNullGreeting() {   
        assertEquals("Hello, friend.", g.greet(null));      
    }
    
    @Test
    public void testShoutGreeting() {   
        assertEquals("HELLO, MIKA.", g.greet("MIKA"));      
    }
    
    @Test
    public void testMultipleGreeting() {   
        assertEquals("Hello, Jari and Josefin.", g.greet("Jari", "Josefin")); 
        assertEquals("Hello, Jake and Minna.", g.greet("Jake", "Minna"));    
        assertEquals("Hello, Tuukka, Risto and Kristiina.", g.greet("Tuukka", "Risto", "Kristiina"));
    }
    
    @Test
    public void testMultipleAndShoutingGreeting() {
        assertEquals("Hello, Tuukka, Risto and Minna. AND HELLO, KRISTIINA AND JARI!",
                g.greet("Tuukka", "KRISTIINA", "JARI", "Risto", "Minna"));
    }
    
//    
//    @Test
//    public void testGreeting() {
//        String expResult = "";
//        String result = g.greeting();        
//        assertEquals(expResult, result);
//        
//    }
    
    
}
