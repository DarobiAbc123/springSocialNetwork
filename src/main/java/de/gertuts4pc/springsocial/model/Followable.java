package de.gertuts4pc.springsocial.model;

import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "PINNWALL_ID")
    protected Set<PinnwallEntry> pinnwallEntries = new HashSet<PinnwallEntry>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<PinnwallEntry> getPinnwallEntries() {
        return pinnwallEntries;
    }

    public void setPinnwallEntries(Set<PinnwallEntry> pinnwallEntries) {
        this.pinnwallEntries = pinnwallEntries;
    }
}
