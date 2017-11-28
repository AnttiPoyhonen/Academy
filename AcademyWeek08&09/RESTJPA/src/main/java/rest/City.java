package rest;

import javax.persistence.*;

@Entity // This tells Hibernate to assume a table out of this class
public class City {

    // PRIMARY KEY, id
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToOne(mappedBy = "capital")
    public Country country;

    // other column names
    private String name, countrycode, district;
    private Integer population;

    public String getName() {
        if (this.name == null || "".equals(this.name)) return "Unknown";
        else return name;
    }

    // NO CONSTRUCTOR! Therefore the application uses the default (empty) constructor
    // and builds a constructor as needed on runtime!


    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
