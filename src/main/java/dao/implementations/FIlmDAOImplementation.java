package main.java.dao.daoImplementation;

import main.java.HibernateSessionFactory;
import main.java.dao.SessionConnector;
import main.java.dao.daoInterface.FilmDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FIlmDAOImplementation extends SessionConnector implements FilmDAO {

    private Session session;

    public FIlmDAOImplementation(){
        this.session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
    }

    public void add(FilmDAO entity) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void update(FilmDAO entity) {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void delete(FilmDAO entity) {
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    public void deleteAll() {

    }

    public FilmDAO getEntityById(int id) {
        return null;
    }

    public List<FilmDAO> getAll() {
        return null;
    }
}
