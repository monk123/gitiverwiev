package by.ayupov.crud;

import by.ayupov.exceptions.DaoException;

import java.util.List;

public interface BaseDao<T> {

    /**
     * Получить все пользователей
     * @return
     */
    List<T> getAll() throws DaoException;

    /**
     * Получить объект с помощью id
     * @param id
     */
    T getEntityById(Long id) throws DaoException;

    /**
     * Cохранить объект в базе данных
     * @param entity
     * @return
     */
    void add(T entity) throws DaoException;

    /**
     * Сохранить изменения, сделанные в объекте
     * @param entity
     */
    void update(T entity) throws DaoException;

    /**
     * Удалить объект из базы данных
     * @param id
     */
    void delete(Long id) throws DaoException;
}
