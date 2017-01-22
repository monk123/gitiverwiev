package by.ayupov.services.impl;

import by.ayupov.dao.ProductsDao;
import by.ayupov.exceptions.DaoException;
import by.ayupov.services.ProductsService;

import java.util.List;

public class ProductsServiceImpl<T> implements ProductsService<T> {

    private ProductsDao<T> productsDao;

    public void setProductsDao(ProductsDao<T> productsDao) {
        this.productsDao = productsDao;
    }

    public List<T> getAll() throws DaoException {
        return productsDao.getAll();
    }

    public T getEntityById(Long id) throws DaoException {
        return productsDao.getEntityById(id);
    }

    public void add(T entity) throws DaoException {
        productsDao.add(entity);
    }

    public void update(T entity) throws DaoException {
        productsDao.update(entity);
    }

    public void delete(Long id) throws DaoException {
        productsDao.delete(id);
    }
}
