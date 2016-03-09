package de.gertuts4pc.springsocial.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractCRUDDao<T> {

    @Autowired protected SessionFactory sessionFactory;
    private final Class<T> databaseClass;

    public AbstractCRUDDao(Class<T> databaseClass) {
        this.databaseClass = databaseClass;
    }

    public T getByID(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (T) session.load(databaseClass, id);
    }

    public boolean entryExist(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        T databaseResult = (T) session.get(databaseClass, id);
        return databaseResult != null;
    }

    public List<T> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<T> trainingGroupModelList = (List<T>) session.createQuery(getDefaultGetAllQuery()).list();
        return trainingGroupModelList;
    }

    public void save(T model) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(model);
        session.flush();
    }

    public void update(T model) {
        Session session = sessionFactory.getCurrentSession();
        session.update(model);
        session.flush();
    }

    public void remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        T databaseResult = (T) session.load(databaseClass, id);
        remove(databaseResult);
    }

    public void remove(T model) {
        Session session = sessionFactory.getCurrentSession();
        if(model != null) {
            session.delete((T) model);
        }
        session.flush();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Class<T> getDatabaseModelClass() {
        return databaseClass;
    }

    protected String getDefaultGetAllQuery() {
        return "from " + databaseClass.getSimpleName();
    }
}
