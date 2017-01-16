package by.ayupov.impl;

import by.ayupov.PriceService;
import by.ayupov.crud.PriceDao;
import by.ayupov.exceptions.DaoException;
import java.util.List;

public class PriceServiceImpl<T> implements PriceService<T> {
    private PriceDao<T> priceDao;

    public List<T> getAll() throws DaoException {
        return priceDao.getAll();
    }

    public T getEntityById(Long id) throws DaoException {
        return priceDao.getEntityById(id);
    }

    public void add(T entity) throws DaoException {
        priceDao.add(entity);
    }

    public void update(T entity) throws DaoException {
        priceDao.update(entity);
    }

    public void delete(Long id) throws DaoException {
        priceDao.delete(id);
    }
}
