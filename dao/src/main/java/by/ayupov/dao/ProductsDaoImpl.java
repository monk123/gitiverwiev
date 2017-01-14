package by.ayupov.dao;

import java.io.Serializable;
import java.util.List;

public class ProductsDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {
    public List<T> getAll() {
        return null;
    }

    public T getEntityById(ID id) {
        return null;
    }

    public void add(T entity) {

    }

    public void update(T entity) {

    }

    public void delete(ID id) {

    }
}
