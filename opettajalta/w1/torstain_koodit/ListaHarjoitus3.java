package fi.academy.torstai;

import java.util.*;

public class ListaHarjoitus3 {
    public static void main(String[] args) {
        Luettelo2 luettelo = new Luettelo2();
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
        luettelo.jarjesta();
        luettelo.tulostaKaikki();
    }

}

class Luettelo2 {
    private final List<Henkilo> lista;

    /**
     * Luo listan ja alustaa sen. Listan alustuksessa
     * käytetään <code>ListaHarjoitus2</code>-luokan
     * <code>nimet</code> muuttujaa.
     */
    public Luettelo2() {
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
}

class Henkilo implements Comparable<Henkilo> {
    private String etunimi;
    private String sukunimi;
    private int ika;

    public Henkilo() {
    }

    public Henkilo(String etunimi, String sukunimi, int ika) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.ika = ika;
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
        return "Henkilo{" + "etunimi='" + etunimi + '\'' + ", sukunimi='" + sukunimi + '\'' + ", ika=" + ika + '}';
    }

    @Override
    public boolean equals(Object obj) {
        Henkilo toinen = (Henkilo)obj;
        return etunimi.equals(toinen.etunimi) && sukunimi.equals(toinen.sukunimi);
    }

    @Override
    public int compareTo(Henkilo o) {
        return etunimi.compareTo(o.etunimi);
    }
}
