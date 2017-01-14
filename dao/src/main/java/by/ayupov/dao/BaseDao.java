package by.ayupov.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {

    /**
     * Получить все пользователей
     * @return
     */
    List<T> getAll();

    /**
     * Получить объект с помощью id
     * @param id
     */
    T getEntityById(ID id);

    /**
     * Cохранить объект в базе данных
     * @param entity
     * @return
     */
    void add(T entity);

    /**
     * Сохранить изменения, сделанные в объекте
     * @param entity
     */
    void update(T entity);

    /**
     * Удалить объект из базы данных
     * @param id
     */
    void delete(ID id);
}
