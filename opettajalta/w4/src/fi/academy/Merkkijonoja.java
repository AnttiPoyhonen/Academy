package fi.academy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Merkkijonoja {
    private final static LukuFontti fontti = new LukuFontti(2);

    public static String asciiTaiteilija(int luku) {
        int numeroita = numeroita(luku);
        // tehdään taulukko, missä kukin numero omassa alkiossaan
        // eli esim. 1234 -> [1, 2, 3, 4]
        int [] numerot = new int[numeroita];
        for (int i = 0; i < numeroita; i++) {
            int kympit = (int)(Math.pow(10, numeroita-i-1));
            numerot[i] = (luku / kympit) % 10;
        }
        //<editor-fold desc="Tarkistelua, kommentoitu pois">
//        List<String> ns = Arrays.stream(numerot).mapToObj(i -> Integer.valueOf(i).toString()).collect(Collectors.toList());
//        System.out.println(String.join(", ", ns));
        //</editor-fold>

        // Toteutetaan StringBuilderilla ascii-luvun rakentaminen
        StringBuilder tulos = new StringBuilder();
        // ensin silmukoidaan rivi kerrallaan, niin monta kertaa kuin fontissa on rivejä
        for (int rivi = 0; rivi < fontti.numero(0).length; rivi++) {
            // jokaisella rivillä lisätään kunkin numeron kyseinen rivi + kaksi välilyöntiä
            for (int i = 0; i < numerot.length; i++) {
                tulos.append(fontti.numero(numerot[i])[rivi]).append("  ");
            }
            // Poistetaan viimeiset välilyönnit, ja lisätään rivinvaihto
            tulos.setLength(tulos.length()-2);
            tulos.append('\n');
        }
        return tulos.toString();
    }

    private static int numeroita(int luku) {
        if (luku == 0) return 1;
        return (int)(Math.floor(Math.log10(luku))) + 1;
    }

    public static void tiedostonSanojenTietoja(String tdosto) {
        System.out.println("\nKäsitellään tiedostoa: " + tdosto + "\n");
        Path polku = Paths.get(tdosto);
        Set<String> uniikkisanat = new TreeSet<>();
        try {
            int sanojayhteensä = 0;
            // Luetaan ensin sanat tiedostosta
            List<String> rivit = Files.readAllLines(polku);
            for(String rivi : rivit) {
                if (rivi.trim().isEmpty()) continue;
                String [] sanat = rivi.trim().split("[\\s\\p{Punct}\"]+");
                sanojayhteensä += sanat.length;
                //System.out.println("*** " + sanat.length + " -- " + rivi);
                List<String> sanatrivillä = Arrays.asList(sanat);
//                if(sanatrivillä.contains(""))  {
//                    System.out.println("-------- " + rivi + " ---------");
//                    for (String s : sanatrivillä) {
//                        System.out.print(String.format("(%s)", s));
//                    }
//                    System.out.println();
//                }
                uniikkisanat.addAll(sanatrivillä);
            }
            uniikkisanat.remove("");  // Ainakin Kalevalasta tulee myös tyhjä sana, jos rivi alkaa "-merkillä
            System.out.println("** Yksittäiset sanat \"aakkostettuna\": ");
            for(String sana : uniikkisanat) {
                System.out.println(String.format("'%s'", sana));
            }

            System.out.println("\n** Sanat järjestettynä pituuden mukaan");
            List<String> uniikkilista = new ArrayList<>(uniikkisanat);
            uniikkilista.sort((o1, o2) -> o1.length()-o2.length());
            for(String sana : uniikkilista) {
                System.out.println(String.format("'%s'", sana));
            }

            System.out.println("\n** Tietoa sanoista:");
            System.out.println("Pisin sana: " + uniikkilista.get(uniikkilista.size()-1));
            System.out.println("Lyhyin sana: " + uniikkilista.get(0));
            System.out.println("Sanoja yhteensä: " + sanojayhteensä);
            System.out.println("Yksittäisiä sanoja: " + uniikkilista.size());
            int merkkejäsanoissa = uniikkilista
                    .stream()
                    .mapToInt(s->s.length())
                    .sum();
            System.out.println("Merkkejä yhteensä: " + merkkejäsanoissa);
            System.out.println("Keskimääräinen pituus: " + merkkejäsanoissa / (double)sanojayhteensä);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String kaanna(String sana) {
        String kaannetty = "";
        for(int i = 0 ; i < sana.length() ; ++i) {
            kaannetty = sana.charAt(i) + kaannetty;
        }
        return kaannetty;
    }

    public static boolean onkoAnagrammi(String sana1, String sana2) {
        if (sana1.length() != sana2.length()) return false;
        char [] ar1 = sana1.toCharArray();
        char [] ar2 = sana2.toCharArray();
        ulompi:
        for (int i = 0; i < ar1.length; i++) {
            char merkki = ar1[i];
            // etsi merkki toisesta taulukosta
            int validejaAlkioitaToisessaTaulussa = ar1.length - i;
            for(int j = 0 ; j < validejaAlkioitaToisessaTaulussa ; ++j) {
                if (ar2[j] == merkki) {
                    // poista merkki toisesta taulukosta
                    for(int k = j ; k < validejaAlkioitaToisessaTaulussa - 1 ; ++k) {
                        ar2[k] = ar2[k+1];
                    }
                    continue ulompi;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean isAnagrammi(String sana1, String sana2) {
        char [] ar1 = sana1.toCharArray();
        char [] ar2 = sana2.toCharArray();
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        return Arrays.equals(ar1, ar2);
    }

    public static String[] konttiTuottaja(String lause) {
        String[] sanat = lause.split(" ");
        String [] tulos = new String[sanat.length];
        for (int i = 0; i < sanat.length ; i++) {
            String sana = sanat[i];
            tulos[i] = kontita(sana);
        }
        return tulos;
    }

    public static String sbKonttiTuottaja(String lause) {
        String[] sanat = lause.split(" ");
        StringBuilder tulos = new StringBuilder();
        for (int i = 0; i < sanat.length ; i++) {
            String sana = sanat[i];
            tulos.append(' ').append(kontita(sana));
        }
        if (sanat.length > 0)
            return tulos.substring(1);
        return tulos.toString();
    }

    public static List<Integer> tekijat(int luku) {
        List<Integer> luvut = new ArrayList<>();
        for (int i = 2; i <= luku; ) {
            if (luku % i == 0) {
                luvut.add(i);
                luku /= i;
            } else {
                ++i;
            }
        }
        return luvut;
    }


    private static String kontita(String sana) {
        String kontti = "kontti";
        String s1, s2;
        // 1. normi kontti => no ko -> ko no
        // 2. asia kontti => a ko -> ko a
        // 3. aasia kontti => aa ko -> koo a
        // 4. aukea kontti => 2
        // 5. saatu kontti => saa ko -> koo sa
        if (onvokaali(sana.charAt(0))) { // 2 tai 3
            if(onvokaali(sana.charAt(1)) && sana.charAt(0) == sana.charAt(1)) { // 3
                s1 = kontti.substring(0, 2) + 'o' + sana.substring(2);
                s2 = sana.substring(0, 1) + kontti.substring(2);
            } else { // 2
                s1 = kontti.substring(0, 2) + sana.substring(1);
                s2 = sana.substring(0, 1) + kontti.substring(2);
            }
        } else { // Jos tänne, niin 1 tai 5
            if (onvokaali(sana.charAt(1)) && sana.charAt(1) == sana.charAt(2)) { // 5
                s1 = kontti.substring(0, 2) + 'o' + sana.substring(3);
                s2 = sana.substring(0, 2) + kontti.substring(2);
            } else { // 1 {
                s1 = kontti.substring(0, 2) + sana.substring(2);
                s2 = sana.substring(0, 2) + kontti.substring(2);
            }
        }
        return s1 + " " + s2;
    }

    private static boolean onvokaali(char c) {
        return "aeiouyäö".contains(""+c);
    }
}


class LukuFontti {
    private static final String[][] numerot1 = new String[10][6];
    private static final String[][] numerot2 = new String[10][6];
    private String[][] numerot;
    static {
        numerot1[0] = " 0000 a00  00a00  00a00  00a 0000 ".split("a");
        numerot1[1] = "1111  a  11  a  11  a  11  a111111".split("a");
        numerot1[2] = " 2222 a22  22a   22 a  22  a222222".split("a");
        numerot1[3] = " 3333 a33  33a   333a33  33a 3333 ".split("a");
        numerot1[4] = "44  44a44  44a444444a    44a    44".split("a");
        numerot1[5] = "555555a55    a55555 a    55a55555 ".split("a");
        numerot1[6] = " 6666 a66    a66666 a66  66a 6666 ".split("a");
        numerot1[7] = "777777a   77 a  77  a 77   a77    ".split("a");
        numerot1[8] = " 8888 a88  88a 8888 a88  88a 8888 ".split("a");
        numerot1[9] = " 9999 a99  99a 99999a    99a 9999 ".split("a");

        numerot2[0] = "000000a00  00a00  00a00  00a000000".split("a");
        numerot2[1] = "1111  a  11  a  11  a  11  a111111".split("a");
        numerot2[2] = "222222a     2a222222a2     a222222".split("a");
        numerot2[3] = "333333a    33a333333a    33a333333".split("a");
        numerot2[4] = "44  44a44  44a444444a    44a    44".split("a");
        numerot2[5] = "555555a55    a555555a    55a555555".split("a");
        numerot2[6] = "666666a66    a666666a66  66a666666".split("a");
        numerot2[7] = "777777a    77a    77a    77a    77".split("a");
        numerot2[8] = "888888a88  88a888888a88  88a888888".split("a");
        numerot2[9] = "999999a99  99a999999a    99a999999".split("a");
    }

    public LukuFontti() {
        this(1);
    }
    public LukuFontti(int variantti) {
        if (variantti == 1) {
            numerot = numerot1;
        }
    }

    public String[] numero(int numero) {
        return numerot1[numero];
    }
}