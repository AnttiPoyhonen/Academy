package rest;

import javax.persistence.*;

@Entity // This tells Hibernate to assume a table out of this class
public class Country {

    // PRIMARY KEY, id
    @Id
    private String code;

    // other column names
    private String name, continent, region, localname, governmentform, headofstate, Code2;
    private Double surfacearea, lifeexpectancy, gnp, GNPOld;
    private Integer indepyear, population;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "capital")
    public City capital;

    public City getCapital() {
        if (this.capital == null) return new City();
        else return this.capital;
    }

    // NO CONSTRUCTOR! Therefore the application uses the default (empty) constructor
    // and builds a constructor as needed on runtime!


    public void setCapital(City capital) {
        this.capital = capital;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocalname() {
        return localname;
    }

    public void setLocalname(String localname) {
        this.localname = localname;
    }

    public String getGovernmentform() {
        return governmentform;
    }

    public void setGovernmentform(String governmentform) {
        this.governmentform = governmentform;
    }

    public String getHeadofstate() {
        return headofstate;
    }

    public void setHeadofstate(String headofstate) {
        this.headofstate = headofstate;
    }

    public String getCode2() {
        return Code2;
    }

    public void setCode2(String code2) {
        Code2 = code2;
    }

    public Double getSurfacearea() {
        return surfacearea;
    }

    public void setSurfacearea(Double surfacearea) {
        this.surfacearea = surfacearea;
    }

    public Double getLifeexpectancy() {
        return lifeexpectancy;
    }

    public void setLifeexpectancy(Double lifeexpectancy) {
        this.lifeexpectancy = lifeexpectancy;
    }

    public Double getGnp() {
        return gnp;
    }

    public void setGnp(Double gnp) {
        this.gnp = gnp;
    }

    public Double getGnpoid() {
        return GNPOld;
    }

    public void setGnpoid(Double GNPOld) {
        this.GNPOld = GNPOld;
    }

    public Integer getIndepyear() {
        return indepyear;
    }

    public void setIndepyear(Integer indepyear) {
        this.indepyear = indepyear;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
