package main.java.dao;

import main.java.HibernateSessionFactory;
import org.hibernate.Session;

public class SessionConnector{
    private Session session;

    public Session openSession(){
        session = HibernateSessionFactory.getSessionFactory().openSession();
        return session;
    }

    public void closeSession(){
        session.close();
    }

    // TODO: 06.12.2018 add abstract methods for specific entities (e.g. getOrdersOfEmployee)
}