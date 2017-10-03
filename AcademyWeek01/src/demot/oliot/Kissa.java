package demot.oliot;

public class Kissa extends Elain {

    private final String rotu;
    private int ika;

    public Kissa () {
        this("tuntematon", "tuntematon", 0);
    }
    
    public Kissa (String nimi) {
        this("tuntematon", nimi, 0);
    }
    
    public Kissa (String rotu, String nimi) {
        this(rotu, nimi, 0);
    }
    
    public Kissa(String rotu, String nimi, int ika) {
        this.rotu = rotu;
        this.setNimi(nimi);
        this.ika = ika;
    }

    public String getRotu() {
        return rotu;
    }

    public int getIka() {
        return this.ika;
    }

    void setIka(int ika) {
        if (ika < 0) {
            return;
        }
        this.ika = ika;
    }
     
    public void kuseksi(){
        
    }
    
    @Override
    public String toString() {
        return "Kissa(" 
                + "rotu: " + this.rotu
                + ", nimi: " + this.getNimi()
                + ", ikä: " + this.ika
                + ").";
    }
    
    @Override
    public Elain lisaanny(){
        return new Kissa();
    }
}
