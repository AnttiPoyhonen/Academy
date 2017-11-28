package fi.academy;

import javax.persistence.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private URI homepage;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id")
    private List<User> users = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getHomepage() {
        return homepage;
    }

    public void setHomepage(URI homepage) {
        this.homepage = homepage;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
        if (user.getCompany() == null || user.getCompany().getId() != id)
            user.setCompany(this);
    }
}
