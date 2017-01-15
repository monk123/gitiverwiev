package by.ayupov.impl;

import by.ayupov.ProductsService;
import by.ayupov.dao.ProductsDao;
import by.ayupov.entity.Products;

import java.io.Serializable;
import java.util.List;

public class ProductsServiceImpl<T, ID extends Serializable> implements ProductsService<T, ID> {

    private ProductsDao<T, ID> productsDao;

    public void setProductsDao(ProductsDao<T, ID> productsDao) {
        this.productsDao = productsDao;
    }

    public List<T> getAll() {
        return productsDao.getAll();
    }

    public T getEntityById(ID id) {
        return productsDao.getEntityById(id);
    }

    public void add(T entity) {
        productsDao.add(entity);
    }

    public void update(T entity) {
        productsDao.update(entity);
    }

    public void delete(ID id) {
        productsDao.delete(id);
    }
}
