package main.java.dao;

import main.java.HibernateSessionFactory;
import org.hibernate.Session;

public class SessionConnector{
    protected Session session;

    protected Session openSession(){
        session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        return session;
    }

    protected void closeSession(){
        session.close();
        HibernateSessionFactory.shutdown();
    }
}