package fi.academy.maanantai;

public class StringBuilderHarjoitus1 {
    public static void main(String[] args) {
        String[] paivat = {"maanantai", "tiistai", "keskiviikko", "torstai", "perjantai", "lauantai", "sunnuntai"};
        StringBuilder viikko = new StringBuilder();
        for(String pv : paivat) {
            viikko.append(pv);
        }
        System.out.println(viikko);
        System.out.println("-----------------------------");
        viikko.delete(0, viikko.length()-1);
        for(String pv : paivat) {
            viikko.append(pv).append('\n');
        }
        System.out.println(viikko);
        System.out.println("-----------------------------");
        viikko.delete(0, viikko.length()-1);
        for(String pv : paivat) {
//            pv = pv.substring(0, 1).toUpperCase()
//                  + pv.substring(1, pv.length());
            // char eka = pv.toUpperCase().charAt();
            char eka = pv.toUpperCase().charAt(0);
            if (eka >= 'a' && eka <= 'z')
                eka = (char)(eka - 'a' + 'A');
            viikko.append(eka)
                    .append(pv.substring(1, pv.length()))
                    .append('\n');
        }
        System.out.println(viikko);
        System.out.println("-----------------------------");
    }
}
