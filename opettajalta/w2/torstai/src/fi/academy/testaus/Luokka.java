package fi.academy.testaus;

public class Luokka {
    private String sana;

    public String getIsoSana() {
        if(sana == null) {
            throw new AlustamatonSanaException("Luokka luokkaa ei alustettu");
        }
        return sana.toUpperCase();
    }

    public String getSana() {
        return sana;
    }

    public void setSana(String sana) {
        this.sana = sana;
    }
}
