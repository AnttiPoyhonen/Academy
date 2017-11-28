package rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {

    // PRIMARY KEY, id
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    // other column names
    private String name;
    private String email;

    // NO CONSTRUCTOR! Therefore the application uses the default (empty) constructor
    // and builds a constructor as needed on runtime!

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}