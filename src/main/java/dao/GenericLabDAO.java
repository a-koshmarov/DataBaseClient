package dao;

import java.util.List;

public interface GenericLabDAO<T> {
    List<T> getAll();
}
