package by.ayupov.impl;

import by.ayupov.CategoryService;
import by.ayupov.dao.impl.CategoryDaoImpl;
import by.ayupov.exceptions.DaoException;

import java.util.List;

public class CategoryServiceImpl<T> implements CategoryService<T> {
    private CategoryDaoImpl<T> categoryDao;

    public List<T> getAll() throws DaoException {
        return categoryDao.getAll();
    }

    public T getEntityById(Long id) throws DaoException {
        return categoryDao.getEntityById(id);
    }

    public void add(T entity) throws DaoException {
        categoryDao.add(entity);
    }

    public void update(T entity) throws DaoException {
        categoryDao.update(entity);
    }

    public void delete(Long id) throws DaoException {
        categoryDao.delete(id);
    }
}
