package fi.academy.beans;

public class Henkilo {

    private String etunimi, sukunimi;
    private int ika;

    public void asetaKaikki(String etunimi, String sukunimi, int ika) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.ika = ika;
    }

    public int getIka() {
        return ika;
    }

    public void setIka(int ika) {
        this.ika = ika;
    }

    public String getSukunimi() {

        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getEtunimi() {

        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }
}
