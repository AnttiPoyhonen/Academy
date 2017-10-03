package fi.academy.torstai.live;

import java.util.*;

public class ListaHarjoitus3 {
    public static void main(String[] args) {
        Luettelo3 luettelo = new Luettelo3();

        //<editor-fold desc="//Fold block: Voidaan tarkistaa toimiiko aiempi koodi vaikka oma tyyppi..">

        boolean ajavanhat = false;
        if (ajavanhat) {
            luettelo.tulostaKaikki();
            luettelo.poistaPäät();
            luettelo.tulostaKaikki();
            Henkilo hlo = new Henkilo("John", "Doe", 1);
            if (luettelo.onkoNimea(hlo)) {
                System.out.println(hlo + " löytyi");
            } else {
                System.out.println(hlo + " ei löydy");
            }
            hlo.setEtunimi("Jane");
            if (luettelo.onkoNimea(hlo)) {
                System.out.println(hlo + " löytyi");
            } else {
                System.out.println(hlo + " ei löydy");
            }
            // Aluoitetaan taas alusta:
            luettelo = new Luettelo3();
        }//</editor-fold>

        System.out.println("\nEnnen järjestämistä:\n----------------------------");
        luettelo.tulostaKaikki();

        System.out.println("\nJärjestettynä, etunimi aakkosissa:\n----------------------------");
        luettelo.jarjesta();
        luettelo.tulostaKaikki();

        System.out.println("\nJärjestettynä iän mukaan:\n----------------------------");
        luettelo.jarjestaIanMukaan();
        luettelo.tulostaKaikki();

        System.out.println("\nPalauta ID-järjestys:\n----------------------------");
        luettelo.palautaAlkuperainenJarjestys();
        luettelo.tulostaKaikki();

        System.out.println("\nJärjestettynä sukunimen pituuden mukaan:\n----------------------------");
        luettelo.tulostaSukunimenPituudenMukaan();
        System.out.println("\nJärjestettynä ID:n mukaan:\n----------------------------");
        luettelo.tulostaKaikki();
    }

}

class Luettelo3 {
    private final List<Henkilo> lista;

    /**
     * Luo listan ja alustaa sen. Listan alustuksessa
     * käytetään <code>ListaHarjoitus2</code>-luokan
     * <code>nimet</code> muuttujaa.
     */
    public Luettelo3() {
        // luo lista, esim. ArrayList
        Henkilo[] hlot = {new Henkilo("John", "Doe", 21),
                new Henkilo("Jane", "Doe", 28),
                new Henkilo("Steven", "Tyler", 55),
                new Henkilo("Matt", "Mulligan", 21),
                new Henkilo("James", "Gosling", 55)};

        // Lisää nimet listaan
        lista = new ArrayList<>(Arrays.asList(hlot));
    }

    /**
     * Luettelon tulostus.
     * Metodi tulostaa tiedon siitä montako nimeä listassa on,
     * sen jälkeen kaikki listan nimet yksi kerrallaan.
     */
    public void tulostaKaikki() {
        System.out.println("Nimiä listassa: " + lista.size());
        for (Henkilo hlo : lista) {
            System.out.println(" - " + hlo);
        }
    }

    /**
     * Luettelon tulostus.
     * Metodi tulostaa tiedon siitä montako nimeä listassa on,
     * sen jälkeen kaikki listan nimet yksi kerrallaan.
     */
    public void jarjesta() {
        Collections.sort(lista);
    }

    /**
     * Metodi poistaa ensimmäisen ja viimeisen nimen listasta.
     *
     * @throws ArrayIndexOutOfBoundsException jos listalla ei ole vähintään kahta nimeä
     */
    public void poistaPäät() throws ArrayIndexOutOfBoundsException {
        lista.remove(0);
        lista.remove(lista.size() - 1);
    }

    /**
     * Metodilla voi etsiä nimeä listasta.
     *
     * @param nimi Nimi, jota halutaan etsiä
     * @return <code>true</code> jos nimi on listassa, muuten <code>false</code>
     */
    public boolean onkoNimea(Henkilo nimi) {
        return lista.contains(nimi);
    }

    public void jarjestaIanMukaan() {
        // Erillinen Comparator interface'in toteutus
        Collections.sort(lista, new HenkiloVertailija());
        // lista.sort(new HenkiloVertailija());
    }

    public void palautaAlkuperainenJarjestys() {
        // Nimetön sisäluokka
        Collections.sort(lista, new Comparator<Henkilo>() {
            @Override
            public int compare(Henkilo o1, Henkilo o2) {
                return o1.getId()-o2.getId();
            }
        });
    }

    public void tulostaSukunimenPituudenMukaan() {
        // Stream API, sort, ei muuta alkuperäistä listaa
        lista.stream()
                .sorted((h1,h2)->h1.getSukunimi().length()-h2.getSukunimi().length())
                .forEach(System.out::println);
    }

}


class Henkilo implements Comparable<Henkilo> {
    private String etunimi;
    private String sukunimi;
    private int ika;
    private final int id;
    private static int seuraavaID = 1;

    public int getId() {
        return id;
    }

    public Henkilo(String etunimi, String sukunimi, int ika) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.ika = ika;
        id = seuraavaID++;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public int getIka() {
        return ika;
    }

    public void setIka(int ika) {
        this.ika = ika;
    }

    @Override
    public String toString() {
        return "Henkilo{" + "etunimi='" + etunimi + '\'' + ", sukunimi='" + sukunimi + '\'' + ", ika=" + ika + '\'' + ", id=" + id +'}';
    }

    @Override
    public boolean equals(Object obj) {
        Henkilo toinen = (Henkilo)obj;
        return etunimi.equals(toinen.etunimi) && sukunimi.equals(toinen.sukunimi);
    }

    @Override
    public int compareTo(Henkilo other) {
        String pienietu = etunimi.toLowerCase();
        return pienietu.compareTo(other.etunimi.toLowerCase());
    }
}
