package harjoitukset;

public class Solmu {

    private Solmu edellinen;
    private Solmu seuraava;
    private int arvo;
    
    public boolean onSeuraava() {
        if(seuraava.getClass() == this.getClass()) {
            return true;
        }
        return false;
    }
    
    public boolean onEdellinen() {
        if(edellinen.getClass() == this.getClass()) {
            return true;
        }
        return false;
    }

    public Solmu getEdellinen() {
        return edellinen;
    }

    public void setEdellinen(Solmu edellinen) {
        this.edellinen = edellinen;
    }

    public Solmu getSeuraava() {
        return seuraava;
    }

    public void setSeuraava(Solmu seuraava) {
        this.seuraava = seuraava;
    }

    public int getArvo() {
        return arvo;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }
    
    public Solmu(Solmu edellinen, Solmu seuraava, int arvo) {
        this.edellinen = edellinen;
        this.seuraava = seuraava;
        this.arvo = arvo;
    }
    
    

}
