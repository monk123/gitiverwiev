package by.ayupov.dao.impl;

import by.ayupov.dao.PriceDao;
import by.ayupov.entity.Price;
import by.ayupov.exceptions.DaoException;
import by.ayupov.util.HibernateSessionFactory;
import lombok.extern.java.Log;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

@Log
public class PriceDaoImpl<T> implements PriceDao<T> {
    private Session currentSession;
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        List<T> tList = currentSession.createQuery("from Price").list();
        tList.forEach(t -> log.info("Price list: " + t));
        return tList;
    }

    @Override
    public T getEntityById(Long id) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        T t = (T) currentSession.get(Price.class, id);
        log.info("Price successfully get by id: " + t);
        return t;
    }

    @Override
    public void add(T entity) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.save(entity);
        log.info("Price successfully save: " + entity);
    }

    @Override
    public void update(T entity) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.update(entity);
        log.info("Price successfully update: " + entity);
    }

    @Override
    public void delete(Long id) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        T t = (T) currentSession.get(Price.class, id);

        if (t != null) currentSession.delete(t);

        log.info("Price successfully delete: " + t);
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
