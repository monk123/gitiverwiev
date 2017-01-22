package by.ayupov.dao.impl;

import by.ayupov.dao.ProductsDao;
import by.ayupov.entity.Products;
import by.ayupov.exceptions.DaoException;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

@Log
public class ProductsDaoImpl<T> implements ProductsDao<T> {
    private Session currentSession;
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        List<T> list = currentSession.createQuery("from Products").list();
        list.forEach(t -> log.info("Products list: " + t));
        return list;
    }

    @Override
    public T getEntityById(Long id) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        T t =  (T) currentSession.load(Products.class, id);
        log.info("Products successfully get by id: " + t);
        return t;
    }

    @Override
    public void add(T entity) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.save(entity);
        log.info("Product successfully save: " + entity);
    }

    @Override
    public void update(T entity) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.update(entity);
        log.info("Products successfully update: " + entity);
    }

    @Override
    public void delete(Long id) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        T t = (T) currentSession.get(Products.class, id);

        if (t != null) currentSession.delete(id);

        log.info("Products successfully delete: " + id);
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
