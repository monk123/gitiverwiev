package by.ayupov.impl;

import by.ayupov.RatingService;
import by.ayupov.crud.impl.RatingDaoImpl;
import by.ayupov.exceptions.DaoException;
import java.util.List;

public class RatingServiceImpl<T> implements RatingService<T> {
    private RatingDaoImpl<T> ratingDao;

    public List<T> getAll() throws DaoException {
        return ratingDao.getAll();
    }

    public T getEntityById(Long id) throws DaoException {
        return ratingDao.getEntityById(id);
    }

    public void add(T entity) throws DaoException {
        ratingDao.add(entity);
    }

    public void update(T entity) throws DaoException {
        ratingDao.update(entity);
    }

    public void delete(Long id) throws DaoException {
        ratingDao.delete(id);
    }
}
