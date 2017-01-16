package by.ayupov.crud.impl;

import by.ayupov.crud.RatingDao;
import by.ayupov.entity.Rating;
import by.ayupov.exceptions.DaoException;
import by.ayupov.util.HibernateSessionFactory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class RatingDaoImpl<T> implements RatingDao<T> {
    private static final Logger logger = Logger.getLogger(RatingDaoImpl.class);

    private Session currentSession;
    private Transaction transaction;

    public RatingDaoImpl() {
    }

    public List<T> getAll() throws DaoException {
        List<T> tList = null;
        try {
            currentSession = HibernateSessionFactory.getSession();
            transaction = currentSession.beginTransaction();

            tList = currentSession.createQuery("from Rating").list();
            transaction.commit();

            for (T t : tList) {
                logger.info("List price: " + t);
            }

        } catch (HibernateException ex) {
            logger.info("Erroe was throw id dao: " + ex);
            transaction.rollback();
            throw new DaoException(ex);
        }

        return tList;
    }

    public T getEntityById(Long id) throws DaoException {
        T t = null;
        try {
            currentSession = HibernateSessionFactory.getSession();
            transaction = currentSession.beginTransaction();

            t = (T) currentSession.get(Rating.class, id);
            transaction.commit();

            logger.error("Rating successfully found: " + t);
        } catch (HibernateException ex) {
            logger.error("Error was throw id dao: " + t);
            transaction.rollback();
            throw new DaoException(ex);
        }

        return t;
    }

    public void add(T entity) throws DaoException {
        try {
            currentSession = HibernateSessionFactory.getSession();
            transaction = currentSession.beginTransaction();
            currentSession.save(entity);
            transaction.commit();
            logger.info("Rating successfully saved: " + entity);
        } catch (HibernateException ex) {
            logger.error("Error was throw id dao: " + ex);
            transaction.rollback();
            throw new DaoException(ex);
        }
    }

    public void update(T entity) throws DaoException {
        try {
            currentSession = HibernateSessionFactory.getSession();
            transaction = currentSession.beginTransaction();
            currentSession.update(entity);
            transaction.commit();
            logger.info("Rating successfully updated: " + entity);
        } catch (HibernateException ex) {
            logger.error("Error was throw id dao: "  + entity);
            transaction.rollback();
            throw new DaoException(ex);
        }
    }

    public void delete(Long id) throws DaoException {
        try {
            currentSession = HibernateSessionFactory.getSession();
            transaction = currentSession.beginTransaction();

            T t = (T) currentSession.get(Rating.class, id);

            if (t != null) currentSession.delete(t);
            transaction.commit();

            logger.info("Rating successfully deleted: " + t);
        } catch (HibernateException ex) {
            logger.error("Error was throw id dao: " + ex);
            transaction.rollback();
            throw new DaoException(ex);
        }
    }
}
