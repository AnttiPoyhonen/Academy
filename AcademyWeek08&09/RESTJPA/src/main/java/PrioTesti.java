
public class PrioTesti {

    public static void main(String[] args) {

        PrioriteetiJono pj = new PrioriteetiJono();

        String c = "Camilla";
        String b = "Bertta";
        String a = "Antti";
        String d = "David";
        String e = "Eemeli";

        System.out.println("\nKoko alussa: " + pj.koko());

        System.out.println("\nLisätään listalle: " + c + ", " + b + ", " + a + ", " + d + ", " + e);

        System.out.println("\nLisätään komennoilla:\n" +
                "  pj.lisää(\"turha\", c);\n" +
                "  pj.lisää(\"tärkeä\", b);\n" +
                "  pj.koko()pj.lisää(\"elintärkeä\", a);\n" +
                "  pj.lisää(e);\n" +
                "  pj.lisää(\"agfa\", d);\n");

        pj.lisää("elintärkeä", a);
        pj.lisää("tärkeä", b);
        pj.lisää("turha", c);
        pj.lisää(e);
        pj.lisää("agfa", d);

        System.out.println("\nEnsimmäinen: " + pj.ensimmäinen());
        System.out.println("Viimeinen: " + pj.viimeinen());
        System.out.println("Koko: " + pj.koko());

        System.out.println("");

        for (Object s : pj.listaaKaikki()) {
            System.out.println((String)s);
        }

        System.out.println("");

        System.out.println("Koko: " + pj.koko());
        System.out.println("Poistetaan turhat.");
        pj.poistaTurhat();

        System.out.println("Koko: " + pj.koko());

        System.out.println("Poistettu '" + b + "'?: " + pj.poistaJonosta(b));
        System.out.println("Koko: " + pj.koko());

    }

}
