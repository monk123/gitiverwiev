package by.ayupov.services.impl;

import by.ayupov.dao.UserDao;
import by.ayupov.exceptions.DaoException;
import by.ayupov.services.UserService;

import java.util.List;

public class UserServiceImpl<T> implements UserService<T> {
    private UserDao<T> userDao;

    public void setUserDao(UserDao<T> userDao) {
        this.userDao = userDao;
    }

    public List<T> getAll() throws DaoException {
        return userDao.getAll();
    }

    public T getEntityById(Long id) throws DaoException {
        return userDao.getEntityById(id);
    }

    public void add(T entity) throws DaoException {
        userDao.add(entity);
    }

    public void update(T entity) throws DaoException {
        userDao.update(entity);
    }

    public void delete(Long id) throws DaoException {
        userDao.delete(id);
    }
}
