package fi.academy.testaus;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class LuokkaTest {
    private Luokka olio;

    @Before
    public void setUp() throws Exception {
        olio = new Luokka();
    }

    @Test
    public void ekatesti() {
        String haettu = olio.getSana();
        String oletettu = null;
        assertEquals("Oletetaan että sana on alussa null", oletettu, haettu);
        assertTrue(1 == 1);
    }

    @Test
    public void uusi() throws Exception {
        olio.setSana("pieni");
    }

    @Test
    public void liukulukutestit() throws Exception {
        assertEquals(1.14, 0.68+0.46, 0.00000001);
    }

    @Test
    public void listaTestiLisäharjoitus() throws Exception {
        List<String> al = new ArrayList<>();
        List<String> ll = new LinkedList<>();
        al.add("yksi"); ll.add(new String("yksi"));
        al.add("kaksi"); ll.add("kaksi");
        assertEquals("Listojen equals toimii", al, ll);
        assertNotSame("Listojen ensimmäinen alkio eri olio",
                al.get(0), ll.get(0));
    }

    @Test(expected = AlustamatonSanaException.class)
    public void alustamatonLuokkaEiTueIsoSanaMetodinKutsua() throws Exception {
        String iso = olio.getIsoSana();
    }

    @Test
    public void testataanLuokkaOlio() throws Exception {
        String s = "Hei";
        Class luokka = s.getClass();
        assertEquals(luokka, String.class);

    }
}