package by.ayupov.crud.impl;

import by.ayupov.crud.ProductsDao;
import by.ayupov.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ProductsDaoImpl<T> implements ProductsDao<T> {
    private static final Logger logger = Logger.getLogger(ProductsDao.class);

    private Session currentSession;
    private Transaction transaction;

    public List<T> getAll() throws DaoException {
        return null;
    }

    public T getEntityById(Long id) throws DaoException {
        return null;
    }

    public void add(T entity) throws DaoException {

    }

    public void update(T entity) throws DaoException {

    }

    public void delete(Long id) throws DaoException {

    }
}
