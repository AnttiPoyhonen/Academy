package fi.academy.harkat;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTest {
    Email email = new Email();

    @Test
    public void tarkistamaileja() {
        assertTrue(email.testaa("nimi@firma.fi"));
        assertTrue(email.testaa("nimi.nimi@firma.fi"));
        assertTrue(email.testaa("user123@firma.fi"));
        assertTrue(email.testaa("k.a_nimi@firma.fi"));
        assertTrue(email.testaa("nimi@firma.co.uk"));

        assertFalse(email.testaa("nimi@firma.fi.com.uk"));
        assertFalse(email.testaa("nimi@firma.fi.c"));
        assertFalse(email.testaa("nimi.firma.fi"));
        assertFalse(email.testaa("@nimi.firma.fi"));
        assertFalse(email.testaa("nimi@firma"));
        assertFalse(email.testaa("nimi.firma.fi@firma"));
        assertFalse(email.testaa("nimi.firma.fi@"));
    }
    @Test
    public void tarkistamailejaääkköset() {
        assertTrue(email.testaa("äiti@koti.net"));
        assertTrue(email.testaa("paavo@väyrynen.net"));
    }

}