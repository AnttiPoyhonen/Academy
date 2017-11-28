package fi.academy;

public class Language {
    private String countrycode;
    private String countryName;
    private String language;
    private boolean official;
    private double percentage;

    public Language() {
    }

    public Language(String countrycode, String countryName, String language, boolean official, double percentage) {
        this.countrycode = countrycode;
        this.countryName = countryName;
        this.language = language;
        this.official = official;
        this.percentage = percentage;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
