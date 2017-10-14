package harjoitukset;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class PinoToteutusTest {
    
    // fixture
    PinoToteutus pino = new PinoToteutus();
    
    @Before
    public void setUp() {        
        pino.push(1);
        pino.push(2);
    }
    
    public PinoToteutusTest() {
    }

    @Test
    public void testSize() {

        int expResult = 2;
        int result = pino.size();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testPush() {
        int expResult = 3;
        pino.push(3);
        int result = (int) pino.peek();
        
        assertEquals(expResult, result);
    }

    @Test
    public void testPop() {
        int expResult = 2;
        int result = (int) pino.pop();
        int expResultSizeAfter = 1;
        int resultSizeAfter = pino.size();
        
        assertEquals(expResult, result);
        assertEquals(expResultSizeAfter, resultSizeAfter);
        
        expResult = 1;
        result = (int) pino.pop();
        expResultSizeAfter = 0;
        resultSizeAfter = pino.size();
        
        assertEquals(expResult, result);
        assertEquals(expResultSizeAfter, resultSizeAfter);
    }

    @Test
    public void testPeek() {
        int expResult = 2;
        int result = (int) pino.peek();
        
        assertEquals(expResult, result);
    }
    
    // testing for null! assertNull
    
    @Test
    public void testEmptyPop() throws NullPointerException {
        pino.clear();
        assertNull(pino.pop());
    }

    @Test
    public void testEmptyPeek() throws NullPointerException {
        pino.clear();
        assertNull(pino.peek());
    }

    @Test
    public void testClear() {
        int expResultSizeAfter = 0;
        
        pino.clear();
        int resultSizeAfter = pino.size();
        
        assertEquals(expResultSizeAfter, resultSizeAfter);
    }

    @Test
    public void testIsEmpty() {        
        boolean expResult = false;
        boolean result = pino.isEmpty();
        
        assertEquals(expResult, result);
        
        pino.clear();
        
        expResult = true;
        result = pino.isEmpty();
        
        assertEquals(expResult, result);
    }
    
}