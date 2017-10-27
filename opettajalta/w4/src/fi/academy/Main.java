package fi.academy;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        sanattiedostossa();
//        asciitaiteilija();
    }


    private static void sanattiedostossa() {
        Merkkijonoja.tiedostonSanojenTietoja("sanoja.txt");
//        Merkkijonoja.tiedostonSanojenTietoja("runo.txt");
    }

    private static void asciitaiteilija() {
        int luku = 1234;
        System.out.println("Luku: " + luku);
        System.out.println(Merkkijonoja.asciiTaiteilija(luku));
        luku = 7569843;
        System.out.println("Luku: " + luku);
        System.out.println(Merkkijonoja.asciiTaiteilija(luku));

    }

    private static void osa1() {
//        tarkistaAnagrammit("silta", "lista");
//        tarkistaAnagrammit("silta", "kista");
        testaileKonttia();
//        tarkistaJakajia();
    }

    private static void tarkistaAnagrammit(String eka, String toka) {
        System.out.println(String.format("Tarkistetaan: %s ja %s", eka, toka));
        System.out.println("\tv1 tarkistus: " + Merkkijonoja.onkoAnagrammi(eka, toka));
        System.out.println("\tv2 tarkistus: " + Merkkijonoja.isAnagrammi(eka, toka));
    }


    private static void testaileKonttia() {
        String lause = "vaihda aamulla auottua maitomukia suurella innolla ainakin aamulla";
        //String konttilause = String.join(" ", Merkkijonoja.konttiTuottaja(lause));
        String konttilause = Merkkijonoja.sbKonttiTuottaja(lause);
        System.out.println(lause);
        System.out.println(konttilause);
    }

    private static void tarkistaJakajia() {
        for (int i = 124; i < 174; i++) {
            tarkistajakajia(i);
        }

    }

    private static void tarkistajakajia(int luku) {
        List<Integer> luvut = Merkkijonoja.tekijat(luku);
        int tulo = luvut.stream().mapToInt(Integer::intValue).reduce(1, (a,b) -> a*b);
        System.out.print("Luku: " + luku);
        System.out.print(", Jakajat: " + luvut);
        System.out.println(", Tarkistusulo: " + tulo);
    }

}
