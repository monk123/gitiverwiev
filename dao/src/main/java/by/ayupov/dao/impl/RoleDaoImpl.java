package by.ayupov.dao.impl;

import by.ayupov.dao.RoleDao;
import by.ayupov.entity.Role;
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
public class RoleDaoImpl<T> implements RoleDao<T> {
    private Session currentSession;
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        List<T> tList = currentSession.createQuery("from Role").list();
        tList.forEach(t -> log.info("Role list: " + t));
        return tList;
    }

    @Override
    public T getEntityById(Long id) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        T t = (T) currentSession.get(Role.class, id);
        log.info("Role successfully get by id: " + t);
        return t;
    }

    @Override
    public void add(T entity) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.save(entity);
        log.info("Role successfully save: " + entity);
    }

    @Override
    public void update(T entity) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        currentSession.update(entity);
        log.info("Role successfully update: " + entity);
    }

    @Override
    public void delete(Long id) throws DaoException {
        currentSession = sessionFactory.getCurrentSession();
        T t = (T) currentSession.get(Role.class, id);

        if (t != null) currentSession.delete(id);

        log.info("Role successfully delete: " + id);
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
