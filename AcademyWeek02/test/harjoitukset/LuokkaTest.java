package harjoitukset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class LuokkaTest {

    // fixture
    private Luokka l = new Luokka();

    // fixture, before-method to prepare variables for testing
    @Before
    public void setUp() {
        l.setSana("iso");
    }

    
    // Hamcrest, org.hamcrest.Matchers.*, .jar from the net
    
    @Test
    public void yksiHamcrestEqualTest() {
        assertThat("yksi", is(equalTo("yksi")));
    }
    
    @Test
    public void hamcrestGreaterThanTest() {
        assertThat(5, is(greaterThan(4)));
    }
    
    @Test
    public void hamcrestCloseToTest() {
        assertThat(0.1 + 0.2, is(closeTo(0.3, 0.000001)));
    }
    
    @Test
    public void hamcrestEqualToIgnoringCaseTest() {
        assertThat("sana", is(equalToIgnoringCase("SANA")));
    }
    
    @Test
    public void hamcrestHasItemTest() {
        assertThat(Arrays.asList(new Integer[]{2, 4, 6, 8, 10}), is(hasItem(10)));
    }
    
    
    // normal tests
    
    @Test
    public void testaaLuokanLuonti() {
        assertNotNull("Olio ei ole null", l);
    }

    @Test
    public void failureTest() throws Exception {
        assertEquals("Isoiksi muuttaminen onnistuu", "ISO", l.getIsoSana());
    }

    @Test
    public void errorTest() throws Exception {
        assertEquals("Iso sana", "ISO", l.getIsoSana());
    }

    @Test
    public void testaaGetIsoSana() {
        assertEquals("UpperCase sana", "ISO", l.getIsoSana());
    }

    @Test
    public void testaaGetSanaPituus() {
        l.setSana("yksi");
        int saatuPituus = l.getSana().length();
        assertEquals("Sanat yhta pitkia", "yksi".length(), saatuPituus);
    }

    @Test
    public void liukulukutestit() {
        assertEquals("Yhtäsuuret int-muuttujat", 1, 1);
        assertEquals(1.14, 0.68 + 0.46, 0.0001);    // delta, hyväksyttävä liukulukuero
    }

    @Test
    public void testaaStringit() {
        String eka = new String("sama");
        String toka = new String(eka);  // new luo aina uuden olion!
        assertEquals(eka, toka);

        assertEquals(eka, toka);  // Success
        // assertSame("Ovatko samat Stringit", eka, toka);  => Failure
        assertNotSame(eka, toka);  // Success        
    }

    @Test
    public void testaaLista() {
        List<String> al = new ArrayList<>();
        List<String> ll = new LinkedList<>();
        al.add("yksi");
        ll.add(new String("yksi"));
        al.add("kaksi");
        ll.add("kaksi");

        // listojakin voi testata assertEquals tai assertSame/NotSame
        assertEquals("Listojen equals toimii!", al, ll);
        assertNotSame("Listojen ensimmäinen alkio onkin eri olio!", al, ll);
    }

    @Test(expected = AlustamatonLuokkaException.class)  // odotettu Exception .class!
    public void alustamatonLuokkaEiTueIsoSanaMetodinKutsua() {
        Luokka k = new Luokka();
        k.getIsoSana();
    }

}
