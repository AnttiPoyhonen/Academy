package demot.oliot;

public class ElainTesti {

    public static void main(String[] args) {
        Kissa katti = new Kissa();

        System.out.println(katti.getRotu());
        /* ei voida asettaa rotua, koska rotu ei muutu
        katti.setRotu("maatiainen"); */
        System.out.println(katti.getRotu());

        System.out.println(katti.getNimi());
        katti.setNimi("Pekka");
        System.out.println(katti.getNimi());

        System.out.println(katti.getIka());
        katti.setIka(1);
        System.out.println(katti.getIka());

        System.out.println(katti.toString());

        tulostaJaLisaanny(katti);

    }
    
    // kutsutaan kissaa "katti" eläin-oliona ja käyttää katti-olion omaa toString
    private static void tulostaJaLisaanny(Elain e) {
        System.out.println("Joku eläin: " + e);
        e.lisaanny();
    }

}
