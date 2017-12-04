package fi.academy.harkat;

import java.util.regex.Pattern;

public class Email {
    String mallistr = "(M+)(.M+)*@M+\\.M{2,}(\\.M{2,})?";
    private Pattern malli; //= Pattern.compile("(\\w+)(.\\w+)*@\\w+\\.\\w+(\\.\\w+)?");

    public Email() {
        //mallistr = mallistr.replaceAll("M", "\\\\w");
        mallistr = mallistr.replaceAll("M", "[\\\\wåäö]");
        malli = Pattern.compile(mallistr, Pattern.CASE_INSENSITIVE);
    }

    public boolean testaa(String s) {
        return malli.matcher(s).matches();
    }
}
