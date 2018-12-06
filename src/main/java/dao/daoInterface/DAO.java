package main.java.dao.daoInterface;

import org.hibernate.Session;

import java.util.List;

public interface DAO<T> {

    void add(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteAll();

    T getEntityById(int id);

    List<T> getAll();
}
