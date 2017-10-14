package harjoitukset;

import java.util.Date;

public class LocHenkilo {

    private String etunimi, sukunimi;
    private Date syntymapaiva;
    private double palkka;
    
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
