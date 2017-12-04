package fi.academy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SanontaHistoria {
    @Id @GeneratedValue
    private int id;
    private String quotetext;
    private String author;
    @Temporal(TemporalType.TIMESTAMP)
    private Date muutettu;
    @JsonIgnore
    @ManyToOne
    Sanonta sanonta;

    public SanontaHistoria() {
        this.muutettu = new Date();
    }

    public SanontaHistoria(String quotetext, String author, Sanonta sanonta) {
        this();
        this.quotetext = quotetext;
        this.author = author;
        this.sanonta = sanonta;
    }
    public SanontaHistoria(Sanonta sanonta) {
        this();
        this.quotetext = sanonta.getQuotetext();
        this.author = sanonta.getAuthor();
        this.sanonta = sanonta;
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

    public Date getMuutettu() {
        return muutettu;
    }

    public void setMuutettu(Date muutettu) {
        this.muutettu = muutettu;
    }

    public Sanonta getSanonta() {
        return sanonta;
    }

    public void setSanonta(Sanonta sanonta) {
        this.sanonta = sanonta;
    }
}
