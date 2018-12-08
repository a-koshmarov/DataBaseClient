package service;

import dao.GenericLabDAO;
import dao.GenericLabDAOImpl;
import org.hibernate.SessionFactory;

import java.util.List;

public class GenericLabServiceImpl<T> implements GenericLabService<T> {

    private GenericLabDAO<T> dao;

    public GenericLabServiceImpl(SessionFactory sessionFactory, Class<T> tClass) {
        this.dao = new GenericLabDAOImpl<T>(sessionFactory, tClass);
    }

    public List<T> getAll() {
        return dao.getAll();
    }
}
