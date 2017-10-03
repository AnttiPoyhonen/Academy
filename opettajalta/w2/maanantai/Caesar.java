package fi.academy.maanantai;

public class Caesar {
    public static void main(String[] args) {
        String merkkijono = "Lällätilää";
        Caesar salaaja = new Caesar();
        String salattu = salaaja.salaa(merkkijono);
        System.out.println(salattu);
        salattu = salaaja.salaa2(merkkijono);
        System.out.println(salattu);
    }

    private String aakkoset = "abcdefghijklmnopqrstuvwxyzåäö";
    private String salaa2(String merkkijono) {
        String uusi = "";
        merkkijono = merkkijono.toLowerCase();
        for (int i = 0 ; i < merkkijono.length() ; ++i) {
            char merkki = merkkijono.charAt(i);
            int positio = aakkoset.indexOf(merkki);
            if (positio < 0) {
                uusi += merkki;
                continue;
            }
            int uusipositio = (positio+3) % aakkoset.length();
            char uusimerkki = aakkoset.charAt(uusipositio);
            uusi += uusimerkki;
        }
        return uusi;
    }

    private String salaa(String merkkijono) {
        String uusi = "";
        for (int i = 0 ; i < merkkijono.length() ; ++i) {
            char uusimerkki = (char)(merkkijono.charAt(i) + 3);
            uusi += uusimerkki;
        }
        return uusi;
    }

}
