package by.ayupov.dao.interfaces;

import java.util.List;

public interface BaseDao<T> {

    /**
     * get all users
     * @return
     */
    List<T> getAll();
    
    /**
     * get user by id
     * @param id
     */
    T getEntityById(Integer id);

    /**
     * save user in DB
     * @param entity
     * @return
     */
    void add(T entity);

    /**
     * update information about entity
     * @param entity
     */
    void update(T entity);

    /**
     * delete entity
     * @param id
     */
    void delete(Integer id);
}
