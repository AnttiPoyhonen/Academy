package com.pankki.bl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TiliTest {

    Tili t = new Tili(100, -500);

    @Before
    public void setUp() {
    }

    @Test
    public void onnistuuOtto() throws Exception {
        assertEquals(100, t.getSaldo(), 0.0001);
        assertTrue(t.otto(50));
        assertEquals(50, t.getSaldo(), 0.0001);
        assertTrue(t.otto(100));
        assertEquals(-50, t.getSaldo(), 0.0001);
    }

    @Test
    public void onnistuuPano() throws Exception {
        assertEquals(100, t.getSaldo(), 0.0001);
        t.pano(50);
        assertEquals(150, t.getSaldo(), 0.0001);

    }

    @Test
    public void getMaksimiNosto() throws Exception {
        assertEquals(600, t.getMaksimiNosto(), 0.0001);
    }

    @Test
    public void nostoYlittaaNostorajan() {
        assertFalse(t.otto(1000));
    }

}