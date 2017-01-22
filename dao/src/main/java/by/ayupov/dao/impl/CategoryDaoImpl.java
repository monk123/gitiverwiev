package by.ayupov.dao.impl;

import by.ayupov.dao.CategoryDao;
import by.ayupov.entity.Category;
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
public class CategoryDaoImpl<T> implements CategoryDao<T> {
    private Session currentSession;
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        List<T> tList = currentSession.createQuery("from Category").list();
        tList.forEach(t -> log.info("Category list: " + t));
        return tList;
    }

    @Override
    public T getEntityById(Long id) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        T t = (T) currentSession.get(Category.class, id);
        log.info("Category successfully get by id: " + id);
        return t;
    }

    @Override
    public void add(T entity) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.save(entity);
        log.info("Category successfully save: " + entity);
    }

    @Override
    public void update(T entity) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.update(entity);
        log.info("Category successfully update: " + entity);
    }

    @Override
    public void delete(Long id) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        T t = (T) currentSession.get(Category.class, id);

        if (t != null) currentSession.delete(t);
        log.info("Category successfully delete: " + t);
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
