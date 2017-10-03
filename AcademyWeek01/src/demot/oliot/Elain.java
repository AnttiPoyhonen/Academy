package demot.oliot;


public abstract class Elain {
    
    private String nimi;
        
    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public Elain() { }
    
    public Elain(String nimi) {
        this.nimi = nimi;
    }
    
    // kaikki eläimet lisääntyy ja tuloksena ehkä eläimiä
    // Elain itse ei voi koskaan olla olio tai lisääntyä
    public abstract Elain lisaanny();
    
}
