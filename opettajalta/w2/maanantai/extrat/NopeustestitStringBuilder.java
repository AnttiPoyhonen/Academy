package fi.academy.maanantai.extrat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class NopeustestitStringBuilder {
    public static void main(String[] args) throws IOException {
        NopeustestitStringBuilder testiolio = new NopeustestitStringBuilder();
        List<String> salatut = new ArrayList<>();
        salatut.add(NopeustestitStringBuilder.testaaNopeus("String katenointi", testiolio::normiStringKatenointi));
        salatut.add(NopeustestitStringBuilder.testaaNopeus("StringBuilder", testiolio::stringBufferinKäyttö));
        salatut.add(NopeustestitStringBuilder.testaaNopeus("Aakkostaulutapa", testiolio::merkkijonoPyöräytys));
        salatut.add(NopeustestitStringBuilder.testaaNopeus("Aakkostaulutapa ilman aakkostaulua", testiolio::merkkijonoPyöräytysLaskemalla));
        salatut.add(NopeustestitStringBuilder.testaaNopeus("Aakkostaulutapa ilman aakkostaulua ja StringBuilderilla", testiolio::merkkijonoPyöräytysLaskemallaJaBuilderilla));
        System.out.println(salatut.get(0).equals(salatut.get(1)));
        System.out.println(salatut.get(2).equals(salatut.get(3)));
        System.out.println(salatut.get(2).equals(salatut.get(4)));
    }

    private static String testaaNopeus(String metodinKuvaus, Supplier<String> function) {
        long alku = System.nanoTime();
        String salattu = function.get();
        long loppu = System.nanoTime();
        double kesto = (loppu - alku) / 1000000.0;
        System.out.println(String.format("Kesto toiminnolle \"%s\": %.4f", metodinKuvaus, kesto));
        return salattu;
    }

    public String normiStringKatenointi() {
        String uusi = "";
        for (int i = 0 ; i < käsiteltäväData.length() ; ++i) {
            char uusimerkki = (char)(käsiteltäväData.charAt(i) + 3);
            uusi += uusimerkki;
        }
        return uusi;
    }

    public String merkkijonoPyöräytys() {
        String uusi = "";
        String aakkoset = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0 ; i < käsiteltäväData.length() ; ++i) {
            char merkki = käsiteltäväData.charAt(i);
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

    public String merkkijonoPyöräytysLaskemalla() {
        String uusi = "";
        for (int i = 0 ; i < käsiteltäväData.length() ; ++i) {
            char merkki = käsiteltäväData.charAt(i);
            if (merkki < 'a' || merkki > 'z') {
                uusi += merkki;
                continue;
            }
            int siirto = (merkki - 'a' + 3) % 26;
            uusi += (char)('a'+siirto);
        }
        return uusi;
    }

    public String merkkijonoPyöräytysLaskemallaJaBuilderilla() {
        StringBuilder uusi = new StringBuilder();
        for (int i = 0 ; i < käsiteltäväData.length() ; ++i) {
            char merkki = käsiteltäväData.charAt(i);
            if (merkki < 'a' || merkki > 'z') {
                uusi.append(merkki);
                continue;
            }
            int siirto = (merkki - 'a' + 3) % 26;
            uusi.append((char)('a'+siirto));
        }
        return uusi.toString();
    }

    public String stringBufferinKäyttö() {
        StringBuilder uusi = new StringBuilder();
        for (int i = 0 ; i < käsiteltäväData.length() ; ++i) {
            char uusimerkki = (char)(käsiteltäväData.charAt(i) + 3);
            uusi.append(uusimerkki);
        }
        return uusi.toString();
    }

    public NopeustestitStringBuilder() throws IOException {
        kokotiedosto = alusta();
        käsiteltäväData = kokotiedosto.toLowerCase();
    }
    private String alusta() throws IOException {
        try(FileReader lukija = new FileReader("flowersofevil.txt");
            BufferedReader bf = new BufferedReader(lukija)) {
            return bf.lines().collect(Collectors.joining("\n"));
        }
    }

    private final String kokotiedosto;
    private String käsiteltäväData;
}
