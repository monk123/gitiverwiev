package by.ayupov.dao.interfaces;

import by.ayupov.exception.DaoException;
import java.util.List;

public interface BaseDao<T> {
    /**
     * get all users
     * @return
     */
    List<T> getAll() throws DaoException;

    /**
     * get user by id
     * @param id
     */
    T getEntityById(Long id) throws DaoException;

    /**
     * save user in DB
     * @param entity
     * @return
     */
    void add(T entity) throws DaoException;

    /**
     * update information about entity
     * @param entity
     */
    void update(T entity) throws DaoException;

    /**
     * delete entity
     * @param id
     */
    void delete(Long id) throws DaoException;
}
