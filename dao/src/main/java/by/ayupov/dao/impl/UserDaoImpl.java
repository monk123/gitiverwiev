package by.ayupov.dao.impl;

import by.ayupov.dao.UserDao;
import by.ayupov.entity.User;
import by.ayupov.exceptions.DaoException;
import by.ayupov.util.HibernateSessionFactory;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Log
public class UserDaoImpl<T> implements UserDao<T> {
    private static Session currentSession;
    private static SessionFactory sessionFactory;
    private static ThreadLocal<Session> threadLocal = new ThreadLocal<>();

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() throws DaoException {
       currentSession = getSession();
       List<T> tList = currentSession.createQuery("from User").list();
       tList.forEach(t -> log.info("User list: " + t));
       return tList;
    }

    @Override
    public T getEntityById(Long id) throws DaoException {
       currentSession = getSession();
       T t = (T) currentSession.get(User.class, id);
       log.info("User successfully get by id: " + t);
       return t;
    }

    @Override
    public void add(T entity) throws DaoException {
        currentSession = getSession();
        currentSession.save(entity);
        log.info("User successfully save: " + entity);
    }

    @Override
    public void update(T entity) throws DaoException {
        currentSession = getSession();
        currentSession.update(entity);
        log.info("User successfully update: " + entity);
    }

    @Override
    public void delete(Long id) throws DaoException {
        currentSession = getSession();
        T t = (T) currentSession.get(User.class, id);

        if (t != null) currentSession.delete(t);

        log.info("User successfully delete: " + t);
    }

    @Override
    public Session getSession() {
        currentSession = (Session) threadLocal.get();
        if (currentSession == null) {
            currentSession = getSessionFactory().openSession();
        }
        threadLocal.set(currentSession);

        return currentSession;
    }

    @Override
    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = HibernateSessionFactory.buildSessionFactory();
        } else {
            sessionFactory.getCurrentSession();
        }

        return sessionFactory;
    }

}

