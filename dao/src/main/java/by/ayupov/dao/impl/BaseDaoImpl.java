package by.ayupov.dao.impl;

import by.ayupov.dao.interfaces.BaseDao;
import by.ayupov.exception.DaoException;
import by.ayupov.util.HibernateSessionFactory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {
    private static final Logger log = Logger.getLogger(BaseDaoImpl.class);
    private HibernateSessionFactory util = null;
    private Session session;

    public Session getSession() {
        session = util.getSession();
        return session;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() throws DaoException {
        try {
            session = getSession();
            List<T> list = session.createQuery("select t from " + getClass().getSimpleName() + " t")
                    .getResultList();
            list.forEach(t -> log.info("list: " + t));
            return list;
        } catch (HibernateException ex) {
            log.error("Error getAll Entity in Dao " + ex);
            throw new DaoException(ex);
        }

    }

    @Override
    public T getEntityById(Long id) throws DaoException {
        try {
            session = getSession();
            T t = (T) session.get(getPersistentClass(), id);
            log.info("Entity successfully get by id: " + t);
            return t;
        } catch (HibernateException ex) {
            log.error("Error getEntityById in Dao " + ex);
            throw new DaoException(ex);
        }
    }

    @Override
    public void add(T entity) throws DaoException {
        try {
            session = getSession();
            session.save(entity);
            log.info("Entity successfully save: " + entity);
        } catch (HibernateException ex) {
            log.error("Error save Entity in Dao " + entity);
            throw new DaoException(ex);
        }
    }

    @Override
    public void update(T entity) throws DaoException {
        try {
            session = getSession();
            session.update(entity);
            log.info("Entity successfully update: " + entity);
        } catch (HibernateException ex) {
            log.error("Error update Entity in Dao " + entity);
            throw new DaoException();
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        try {
            session = getSession();
            T t = (T) session.get(getPersistentClass(), id);

            if (t != null) session.delete(id);

            log.info("Entity successfully delete: " + t);
        } catch (HibernateException ex) {
            log.error("Error delete Entity in Dao " + ex);
            throw new DaoException(ex);
        }
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
