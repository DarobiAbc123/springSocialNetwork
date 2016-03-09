package de.gertuts4pc.springsocial.model;

import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(name = "PAGE_TYPE")
@Table(name = "USER_AND_PAGES")
public abstract class Followable {

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name = "ID")
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
