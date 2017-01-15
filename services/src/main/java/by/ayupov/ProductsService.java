package by.ayupov;

import by.ayupov.entity.Products;
import java.io.Serializable;
import java.util.List;

public interface ProductsService<T, ID extends Serializable> {
    List<T> getAll();

    T getEntityById(ID id);

    void add(T entity);

    void update(T entity);

    void delete(ID id);
}
