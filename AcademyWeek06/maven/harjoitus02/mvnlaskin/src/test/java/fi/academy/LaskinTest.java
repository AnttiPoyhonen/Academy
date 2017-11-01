package fi.academy;

import static org.junit.Assert.*;
import org.junit.Test;

public class LaskinTest {

    Laskin laskin = new Laskin();

    @Test
    public void testaaLaskinosaaSummata() {
        assertEquals(3, laskin.laskeYhteen(1, 2));
        assertEquals(4, laskin.laskeYhteen(2, 2));
    }

    @Test
    public void testaaLaskinOsaaSummataKolmeLukua() {
        assertEquals(10, laskin.laskeYhteen(3, 3, 4));
        assertEquals(12, laskin.laskeYhteen(2, 6, 4));
    }
    
    @Test
    public void testaaLaskinOsaaSummataNLukua() {
        assertEquals(50, laskin.laskeYhteen(5, 5, 5, 5, 5, 5, 5, 5, 5, 5));        
    }
    
    @Test // (expected = NullPointerException.class)
    public void laskinEiKaaduRajarvoilla () throws Exception {
        assertEquals(-1, laskin.laskeYhteen(-1));
        assertEquals(0, laskin.laskeYhteen());
        assertEquals(-2, laskin.laskeYhteen(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(0, laskin.laskeYhteen(Integer.MIN_VALUE, Integer.MIN_VALUE));
        assertEquals(-1, laskin.laskeYhteen(Integer.MAX_VALUE, Integer.MIN_VALUE));
        // assertEquals(0, laskin.laskeYhteen(null));
    }
    
    
    @Test
    public void testaaLaskinOsaaSummataDouble () {
        assertEquals(0.3, laskin.laskeYhteen(0.1, 0.2), 0.0001);
        assertEquals(-0.3, laskin.laskeYhteen(-0.1, -0.2), 0.0001);
        assertEquals(0.8, laskin.laskeYhteen(0.2, 0.3, 0.3), 0.0001);
        assertTrue(Double.isInfinite(laskin.laskeYhteen(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)));
        assertTrue(Double.isInfinite(laskin.laskeYhteen(Double.POSITIVE_INFINITY, 0,2)));
        assertTrue(Double.isNaN(laskin.laskeYhteen(Double.NaN)));
        assertTrue(Double.isInfinite(laskin.laskeYhteen(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY)));
        assertTrue(Double.isInfinite(laskin.laskeYhteen(Double.MAX_VALUE, Double.MAX_VALUE)));
    }



}