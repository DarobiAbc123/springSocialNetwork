package de.gertuts4pc.springsocial.dao;

import de.gertuts4pc.springsocial.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends AbstractCRUDDao<User> {

    public UserDAO() {
        super(User.class);
    }

    public boolean userWithCredentialsExists(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User WHERE username = :username AND password = :password").setString("username", username).setString("password", password);
        return query.uniqueResult() != null;
    }

    public User getUserByCredentials(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User WHERE username = :username AND password = :password").setString("username", username).setString("password", password);
        return (User) query.uniqueResult();
    }

    public boolean usernameExists(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User WHERE username = :username").setString("username", username);
        return query.uniqueResult() != null;
    }

    public boolean emailExists(String eMailAddress) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User WHERE eMailAddress = :eMailAddress").setString("eMailAddress", eMailAddress);
        return query.uniqueResult() != null;
    }

}
