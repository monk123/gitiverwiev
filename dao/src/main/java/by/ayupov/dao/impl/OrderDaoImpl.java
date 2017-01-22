package by.ayupov.dao.impl;

import by.ayupov.dao.OrderDao;
import by.ayupov.entity.Order;
import by.ayupov.exceptions.DaoException;
import lombok.extern.java.Log;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

@Log
public class OrderDaoImpl<T> implements OrderDao<T>  {
    private Session currentSession;
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() throws DaoException {
       currentSession = sessionFactory.getCurrentSession();
       List<T> tList = currentSession.createQuery("from Order").list();
       tList.forEach(t -> log.info("Order list: " + t));
       return tList;
    }

    @Override
    public T getEntityById(Long id) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        T t = (T) currentSession.get(Order.class, id);
        log.info("Order successfully get by id: " + t);
        return t;
    }

    @Override
    public void add(T entity) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.save(entity);
        log.info("Order successfully save: " + entity);
    }

    @Override
    public void update(T entity) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.update(entity);
        log.info("Order successfully update: " + entity);
    }

    @Override
    public void delete(Long id) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        T t = (T) currentSession.get(Order.class, id);

        if (t != null) currentSession.delete(t);

        log.info("Order successfully delete: " + t);
    }

    @Override
    public Session getSession() {
        return null;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return null;
    }
}
