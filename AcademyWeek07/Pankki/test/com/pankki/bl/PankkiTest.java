package com.pankki.bl;

import org.junit.Test;

import static org.junit.Assert.*;

public class PankkiTest {

    @Test
    public void nostot() {

        Tili tili1 = new Tili(10.0, -1000.0);
        Tili tili2 = new Tili(20.0, -2000.0);

        Tili[] tilit = { tili1, tili2 };
        Pankki pankki = new Pankki(tilit);

        pankki.talleta(1, 123.0);

        assertTrue("Tili 1: 5 euron nosto tulee palauttaa true",
                pankki.nosta(1, 5.0));
        assertTrue("Tili 1: 500 euron nosto tulee palauttaa true",
                pankki.nosta(1, 500.0));

    }

    @Test
    public void liianSuuriNosto() {

        Tili tili1 = new Tili(10.0, -1000.0);
        Tili tili2 = new Tili(20.0, -2000.0);

        Tili[] tilit = { tili1, tili2 };
        Pankki pankki = new Pankki(tilit);

        pankki.talleta(1, 123.0);

        assertFalse("Tili 2: 4000 euron nosto ylittää luottorajan reilusti - pitäisi olla false",
                pankki.nosta(1, 5000));

    }


}