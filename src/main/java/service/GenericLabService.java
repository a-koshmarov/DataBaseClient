package service;

import org.hibernate.SessionFactory;

import java.util.List;

public interface GenericLabService<T> {
    List<T> getAll();
}
