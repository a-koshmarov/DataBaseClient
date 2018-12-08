package service;

import java.util.List;

public interface GenericLabService<T> {
    List<T> getAll();
}
