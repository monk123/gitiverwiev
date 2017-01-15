package by.ayupov.dao.impl;

import by.ayupov.dao.OrderDao;
import by.ayupov.entity.Order;
import by.ayupov.exceptions.DaoException;
import by.ayupov.util.HibernateSessionFactory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class OrderDaoImpl<T> implements OrderDao<T>  {
    private static final Logger logger = Logger.getLogger(OrderDaoImpl.class);

    private Session currentSession;
    private Transaction transaction;

    public List<T> getAll() throws DaoException {
        List<T> tList = null;
        try {
            currentSession = HibernateSessionFactory.getSession();
            transaction = currentSession.beginTransaction();

            tList = currentSession.createQuery("from Order").list();
            transaction.commit();

            for (T t : tList) {
                logger.info("List order: " + t);
            }

        } catch (HibernateException ex) {
            logger.info("Error was throw id dao: " + ex);
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

            t = (T) currentSession.get(Order.class, id);
            transaction.commit();

            logger.error("Order successfully found: " + t);
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
            logger.info("Order successfully saved: " + entity);
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
            logger.info("Order successfully updated: " + entity);
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

            T t = (T) currentSession.get(Order.class, id);

            if (t != null) currentSession.delete(t);
            transaction.commit();

            logger.info("Order successfully deleted: " + t);
        } catch (HibernateException ex) {
            logger.error("Error was throw id dao: " + ex);
            transaction.rollback();
            throw new DaoException(ex);
        }
    }
}
