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
        
}
