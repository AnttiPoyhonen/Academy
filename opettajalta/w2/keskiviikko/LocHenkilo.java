package fi.academy.keskiviikko;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LocHenkilo {
    private String etunimi;
    private String sukunimi;
    private Date syntymapaiva;
    private double palkka;

    public LocHenkilo() {
        // Päiväys: Huhtikuun 13. 1951
        this("Aku", "Ankka",
                //new Date(51, 3, 13),
                new GregorianCalendar(2017, Calendar.APRIL, 13).getTime(),
                2313.56);
    }

    public LocHenkilo(String etunimi, String sukunimi, Date syntymapaiva, double palkka) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymapaiva = syntymapaiva;
        this.palkka = palkka;
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

    public Date getSyntymapaiva() {
        return syntymapaiva;
    }

    public void setSyntymapaiva(Date syntymapaiva) {
        this.syntymapaiva = syntymapaiva;
    }

    public double getPalkka() {
        return palkka;
    }

    public void setPalkka(double palkka) {
        this.palkka = palkka;
    }
}
