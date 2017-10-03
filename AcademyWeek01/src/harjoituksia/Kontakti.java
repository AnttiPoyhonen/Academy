package harjoituksia;

import java.io.Serializable;

public class Kontakti implements Comparable<Kontakti>, Serializable {

    private String nimi;
    private String numero;

    int ID;

    public int getID() {
        return ID;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Kontakti(String numero) {
        this("tuntematon", numero);
    }

    public Kontakti(String nimi, String numero) {
        this.nimi = nimi;
        this.numero = numero;

        this.ID = Puhelinluettelo.nextID;
        Puhelinluettelo.nextID++;
    }

    @Override
    public String toString() {
        return this.ID + ": " + nimi + ", " + numero;
    }

    @Override
    public int compareTo(Kontakti k) {

        // JOS identtinen, palauta 0
        if (this.nimi.compareTo(k.nimi) == 0) {
            return 0;
        } else {
        // järjestä etunimen mukaan
        return this.nimi.compareTo(k.nimi);
        }

    }

}
