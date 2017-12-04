package fi.academy.harkat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RekNro {
    private Pattern malli = Pattern.compile("[A-ZÅÄÖ]{1,3}-[1-9]\\d{0,2}");
    private Matcher matchaaja;
    public RekNro() {
    }

    public boolean testaa(String s) {
        matchaaja = malli.matcher(s);
        return matchaaja.matches();
    }
}
