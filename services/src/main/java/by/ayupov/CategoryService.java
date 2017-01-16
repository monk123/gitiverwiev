package by.ayupov;

import by.ayupov.exceptions.DaoException;
import java.util.List;

public interface CategoryService<T> {
    List<T> getAll() throws DaoException;

    T getEntityById(Long id) throws DaoException;

    void add(T entity) throws DaoException;

    void update(T entity) throws DaoException;

    void delete(Long id) throws DaoException;
}
