package fi.academy.testaus;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class HarjoitusHamcrestTest {
    @Test
    public void yksinkertainen() {
        assertThat("yksi", is(equalTo("yksi")));
    }

    @Test
    public void numerot() {
        assertThat(5, is(greaterThan(4)));
        assertThat(0.3, is(closeTo(0.1+0.2, 0.000001)));
    }

    @Test
    public void merkkijonot() {
        String yksi = "sana";
        String kaksi = "sana";
        String eri = new String("sana");
        assertThat(yksi, is(equalTo(eri)));
        assertThat(yksi, is(not(sameInstance(eri))));
        assertThat(yksi, equalToIgnoringCase(yksi.toUpperCase()));
        assertThat(yksi, containsString(yksi.substring(0, 2)));
    }

    @Test
    public void kokoelmat() {
        List<Integer> lista = Arrays.asList(new Integer[]{2, 4, 6, 8, 10});
        assertThat(lista, hasItem(10));
        assertThat(lista, hasItems(4, 8));
        assertThat(lista, not(hasItem(12)));
    }



}
