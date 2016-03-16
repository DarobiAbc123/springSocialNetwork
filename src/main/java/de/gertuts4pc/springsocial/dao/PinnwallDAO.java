package de.gertuts4pc.springsocial.dao;

import de.gertuts4pc.springsocial.model.Followable;
import de.gertuts4pc.springsocial.model.PinnwallEntry;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PinnwallDAO extends AbstractCRUDDao<PinnwallEntry> {

    public PinnwallDAO() {
        super(PinnwallEntry.class);
    }

    public List<PinnwallEntry> getSortedEntriesForFollowable(Followable followable) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT post FROM PinnwallEntry post INNER JOIN post.author fol WHERE fol = :followable ORDER BY post.postOn DESC").setEntity("followable", followable);
        return query.list();
    }

}
