package fi.academy;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Kokoelmat {
    public static void main(String[] args) {
        harj13();
    }
    public static void harj13() {
        List<String> kirjaimet = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            kirjaimet.add(""+ c);
        }
        System.out.println(kirjaimet);
        System.out.println("Kirjaimia: " + kirjaimet.size());
        int mKirjaimenPositio = kirjaimet.indexOf("M");
        System.out.println("M-kirjaimen positio: " + mKirjaimenPositio);

        System.out.println("Sekoitetaan..");
        Collections.shuffle(kirjaimet);
        System.out.println(kirjaimet);
        mKirjaimenPositio = kirjaimet.indexOf("M");
        System.out.println("M-kirjaimen positio nyt: " + mKirjaimenPositio);

        System.out.println("\nLisätään ÅÄÖ");
        int aKirjaimenPositio = kirjaimet.indexOf("A");
        // 'Å' ennen kirjainta 'A', 'Ä' kirjaimen 'A' perään ja 'Ö' listan ensimmäiseksi
        // Huomaa järjestys miten lisätään, viimeseksi tuleva ensin
        kirjaimet.add(aKirjaimenPositio+1, "Ä");
        kirjaimet.add(aKirjaimenPositio, "Å");
        kirjaimet.add(0, "Ö");
        System.out.println(kirjaimet);

        System.out.println("\nJärjestetään taas");
        System.out.println("Ensin Collections.sort()");
        Collections.sort(kirjaimet);
        System.out.println(kirjaimet);
        System.out.println("Sitten suomalaisittain käyttäen Collator-luokkaa");
        // https://docs.oracle.com/javase/tutorial/i18n/text/locale.html
        Collator kollaattori = Collator.getInstance(new Locale("fi", "FI"));
        Collections.sort(kirjaimet, kollaattori);
        System.out.println(kirjaimet);

        System.out.println("\nVokaalit pois");
        String vokaalit = "AEIOUYÅÄÖ";
        // seuraava ei toimisi, listaan tulisi vain yksi alkio, tyyppiä char[], kokoelmat eivät pidä primitiivityypeistä
        //kirjaimet.removeAll(Arrays.asList(vokaalit.toCharArray()));
        // joten
        List<String> vokaaliLista = vokaalit.chars().mapToObj(c->String.valueOf((char)c)).collect(Collectors.toList());
        kirjaimet.removeAll(vokaaliLista);
        System.out.println(kirjaimet);

        System.out.println("\nVokaalit takaisin");
        kirjaimet.addAll(vokaaliLista);
        System.out.println(kirjaimet);
        Collections.sort(kirjaimet, kollaattori);
        System.out.println(kirjaimet);
    }
}
