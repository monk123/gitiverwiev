package by.ayupov.impl;

import by.ayupov.OrderService;
import by.ayupov.crud.impl.OrderDaoImpl;
import by.ayupov.exceptions.DaoException;

import java.util.List;

public class OrderServiceImpl<T> implements OrderService<T> {
    private OrderDaoImpl<T> orderDao;

    public List<T> getAll() throws DaoException {
        return orderDao.getAll();
    }

    public T getEntityById(Long id) throws DaoException {
        return orderDao.getEntityById(id);
    }

    public void add(T entity) throws DaoException {
        orderDao.add(entity);
    }

    public void update(T entity) throws DaoException {
        orderDao.update(entity);
    }

    public void delete(Long id) throws DaoException {
        orderDao.delete(id);
    }
}
