package by.ayupov.dao.impl;

import by.ayupov.dao.RatingDao;
import by.ayupov.entity.Rating;
import by.ayupov.exceptions.DaoException;
import by.ayupov.util.HibernateSessionFactory;
import lombok.extern.java.Log;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

@Log
public class RatingDaoImpl<T> implements RatingDao<T> {
    private Session currentSession;
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        List<T> tList = currentSession.createQuery("from Rating").list();
        tList.forEach(t -> log.info("Rating list: " + t));
        return tList;
    }

    @Override
    public T getEntityById(Long id) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        T t = (T) currentSession.get(Rating.class, id);
        log.info("Rating successfully get by id: " + t);
        return t;
    }

    @Override
    public void add(T entity) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.save(entity);
        log.info("Rating successfully save: " + entity);
    }

    @Override
    public void update(T entity) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.update(entity);
        log.info("Rating successfully update: " + entity);
    }

    @Override
    public void delete(Long id) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        T t = (T) currentSession.get(Rating.class, id);

        if (t != null) currentSession.delete(id);

        log.info("Rating successfully delete: " + id);
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
