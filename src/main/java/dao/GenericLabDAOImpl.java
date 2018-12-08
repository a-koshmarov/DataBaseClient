package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class GenericLabDAOImpl<T> implements GenericLabDAO<T> {

    private SessionFactory sessionFactory;
    private Class<T> tClass;

    public GenericLabDAOImpl(SessionFactory sessionFactory, Class<T> tClass) {
        this.sessionFactory = sessionFactory;
        this.tClass = tClass;
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<T> entities = session.createQuery("from " + tClass.getName()).list();
        session.getTransaction().commit();

        return entities;
    }
}
