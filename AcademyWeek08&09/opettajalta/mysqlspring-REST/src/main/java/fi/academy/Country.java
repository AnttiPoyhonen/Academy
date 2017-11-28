package fi.academy;

public class Country {
    private String code;
    private String name;
    private String localName;
    private String continent;
    private double surfaceArea;
    private short indepYear;
    private int population;

    public Country() {
    }

    public Country(String code, String name, String localName, String continent, double surfaceArea, short indepYear, int population) {
        this.code = code;
        this.name = name;
        this.localName = localName;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public short getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(short indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }
}
