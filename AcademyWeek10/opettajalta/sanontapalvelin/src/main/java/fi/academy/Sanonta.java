package fi.academy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sanonta {
    @Id
    @GeneratedValue
    private int id;
    private String quotetext;
    private String author;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<SanontaHistoria> historia = new ArrayList<>();

    public Sanonta() {
    }

    public Sanonta(String quotetext, String author) {
        this.quotetext = quotetext;
        this.author = author;
        historia.add(new SanontaHistoria(this));
    }

    public void paivitaTiedot(Sanonta uudet) {
        this.quotetext = uudet.quotetext;
        this.author = uudet.author;
        historia.add(new SanontaHistoria(this));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuotetext() {
        return quotetext;
    }

    public void setQuotetext(String quotetext) {
        this.quotetext = quotetext;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<SanontaHistoria> getHistoria() {
        return historia;
    }

    public void setHistoria(List<SanontaHistoria> historia) {
        this.historia = historia;
    }

    public void aloitaHistoria() {
        historia.add(new SanontaHistoria(this));
    }
}
