package fi.academy.harkat;

import org.junit.Test;

import static org.junit.Assert.*;

public class RekNroTest {
    RekNro rekNro = new RekNro();
    @Test
    public void testaa3ja3() {
        assertTrue("Kolme ja kolme testi, oikea arvo", rekNro.testaa("ABC-123"));
        assertTrue("Kolme ja kolme testi, oikea arvo", rekNro.testaa("ÄÖÅ-123"));
        assertFalse("Kolme ja kolme testi, oikea 6 kirjainta", rekNro.testaa("ABC-ABC"));
        assertFalse("Kolme ja kolme testi, oikea 6 kirjainta", rekNro.testaa("abc-123"));
        assertFalse("Liian pitkä", rekNro.testaa("AAAA-1234"));
        assertFalse("Nollalla alkava numero", rekNro.testaa("ABC-011"));
        assertFalse("Nollalla alkava numero", rekNro.testaa("ABC-001"));
    }

    @Test
    public void testaamuutpituudet() {
        assertTrue(rekNro.testaa("AB-123"));
        assertFalse(rekNro.testaa("AB-01"));
        assertTrue(rekNro.testaa("AB-1"));
    }

}