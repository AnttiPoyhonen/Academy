package harjoitukset;

public class Luokka {

    private String sana;

    public String getIsoSana() {
        try {

            return sana.toUpperCase();
        } catch (NullPointerException e) {
            throw new AlustamatonLuokkaException("Luokkaa 'Luokka' ei ole alustettu");
        }
    }

    public String getSana() {
        return sana;
    }

    public void setSana(String sana) {
        this.sana = sana;
    }

}

class AlustamatonLuokkaException extends RuntimeException {

    public AlustamatonLuokkaException() {
    }

    public AlustamatonLuokkaException(String message) {
        super(message);
    }

    public AlustamatonLuokkaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
