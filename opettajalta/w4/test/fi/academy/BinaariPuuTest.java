package fi.academy;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaariPuuTest {
    BinaariPuu puu = new BinaariPuu();

    @Test
    public void tarkistaPuunLuonti() {
        assertEquals(0, puu.size());
        assertTrue(puu.isEmpty());
    }

    @Test
    public void tarkistaPuuhunLisääminen() {
        assertTrue(puu.isEmpty());
        puu.add(42);
        assertFalse(puu.isEmpty());
        assertEquals(1, puu.size());
        puu.add(105);
        assertEquals(2, puu.size());
    }

    @Test
    public void tarkistaEtteiDuplikaattejaHyväksytä() {
        puu.add(42);
        puu.add(52);
        assertFalse(puu.add(42));
        assertEquals(2, puu.size());
        puu.tulosta();
    }

    @Test
    public void tarkisteleLöytyykö() {
        puu.add(42);
        assertTrue(puu.contains(42));
        assertFalse(puu.contains(41));
        assertFalse(puu.contains(43));
        puu.add(40);
        puu.add(37);
        puu.add(38);
        puu.add(35);
        puu.add(44);
        puu.add(51);
        assertTrue(puu.contains(38));
        assertTrue(puu.contains(35));
        assertFalse(puu.contains(36));
        assertFalse(puu.contains(50));
        assertFalse(puu.contains(52));
    }

}