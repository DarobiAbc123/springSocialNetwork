package de.gertuts4pc.springsocial.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "wall")
public class PinnwallEntry {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name = "ID")
    private long id;

    @Column(name = "text")
    private String text;

    @Column(name = "postOnDate")
    private Calendar postOn;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "PINNWALL_ID")
    private Followable author;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Calendar getPostOn() {
        return postOn;
    }

    public void setPostOn(Calendar postOn) {
        this.postOn = postOn;
    }

    public Followable getAuthor() {
        return author;
    }

    public void setAuthor(Followable author) {
        this.author = author;
    }
}
