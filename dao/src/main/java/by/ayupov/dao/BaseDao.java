package by.ayupov.dao;

import by.ayupov.exceptions.DaoException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public interface BaseDao<T> {

    /**
     * get all users
     * @return
     */
    List<T> getAll() throws DaoException;

    /**
     * get user with an id
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

    /**
     * return new session or get current session
     * @return
     */
    Session getSession();

    /**
     * return SessionFactory
     * @return
     */
    SessionFactory getSessionFactory();

}
