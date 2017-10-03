package harjoituksia;

import fi.academy.LaitonIkaException;
import java.util.Objects;

public class Henkilo implements Comparable<Henkilo> {

    private String etunimi;
    private String sukunimi;
    private int ika;
    private final int ID;
    private static int nextID = 1;

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        if (etunimi == null) {
            throw new NullPointerException("Nimeä ei voi jättää tyhjäksi!");
        } else {
            this.etunimi = etunimi;
        }
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        if (sukunimi == null) {
            throw new NullPointerException("Nimeä ei voi jättää tyhjäksi!");
        } else {
            this.sukunimi = sukunimi;
        }
    }

    public int getID() {
        return ID;
    }

    public int getIka() {
        return ika;
    }

    public void setIka(int ika) throws LaitonIkaException {
        if (ika < 0 || ika > 120) {
            throw new LaitonIkaException("Iän pitää olla välillä 0-120!");
        }
        this.ika = ika;
    }

    public Henkilo(String etunimi) throws LaitonIkaException {
        this(etunimi, "", 0);
    }

    public Henkilo(String etunimi, String sukunimi) throws LaitonIkaException {
        this(etunimi, sukunimi, 0);
    }

    public Henkilo(String etunimi, String sukunimi, int ika) throws LaitonIkaException {

        if (etunimi == null || sukunimi == null) {
            throw new NullPointerException("Nimeä ei voi jättää tyhjäksi!");
        } else {
            this.etunimi = etunimi;
            this.sukunimi = sukunimi;
        }

        if (ika < 0 || ika > 120) {
            throw new LaitonIkaException("Iän pitää olla välillä 0-120!");
        }

        this.ika = ika;

        this.ID = Henkilo.nextID;
        Henkilo.nextID++;
    }

    @Override
    public String toString() {
        return "Henkilö (ID:" + this.ID + "): "
                + this.etunimi + " "
                + this.sukunimi + ", "
                + this.ika;
    }

    // equals() with manual entry parameters
    public boolean equals(String etunimi, String sukunimi, int ika) {
        if (this.etunimi.equals(etunimi)
                && this.sukunimi.equals(sukunimi)
                && this.ika == ika) {
            return true;
        } else {
            return false;
        }
    }

    @Override // miksi näin?
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.etunimi);
        hash = 79 * hash + Objects.hashCode(this.sukunimi);
        hash = 79 * hash + this.ika;
        return hash;
    }

    // equals override voisi olla, että vertaillaan toStringiä ja palautetaan vertailun boolean!
    /*
    @Override
    public boolean equals(Object o) {
        return toString.equals(o.toString());
    }    
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Henkilo other = (Henkilo) obj; // other = tarkistettava object

        // equals-testissä ei voi testata ID:tä, koska ID on aina eri, vaikka olisi samanlainen;
        // jos on sama, silloin jo aiempi this == obj on palauttanut true
        if (this.ika != other.ika) {
            return false;
        }
        if (!Objects.equals(this.etunimi, other.etunimi)) {
            return false;
        }
        if (!Objects.equals(this.sukunimi, other.sukunimi)) {
            return false;
        }

        return true;
    }

    @Override
    public int compareTo(Henkilo o) {
        
        // JOS identtinen, palauta 0
        if (this.etunimi.compareTo(o.etunimi) == 0
                && this.sukunimi.compareTo(o.sukunimi) == 0
                && this.ika == o.ika) {
            return 0;
        }
        
        return this.etunimi.compareTo(o.etunimi);
        

    }
}
