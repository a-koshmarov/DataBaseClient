package main.java;

import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

//        FilmDAO filmDAO = new FilmDAO();
//
//        filmDAO.setIso(100);
//        filmDAO.setDevelopmentMethod("ruki");
//        filmDAO.setManufacturer("SomeFilme");
//        filmDAO.setShots(36);


//        session.save(filmDAO);
        session.getTransaction().commit();

        session.close();
        HibernateSessionFactory.shutdown();
    }
}
