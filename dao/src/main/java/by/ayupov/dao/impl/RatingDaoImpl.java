package by.ayupov.dao.impl;

import by.ayupov.dao.interfaces.RatingDao;
import by.ayupov.entity.Rating;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of {@link RatingDao} interface
 *
 * @author Vadim Ayupov
 */
@Repository
@Log
public class RatingDaoImpl implements RatingDao {
    private SessionFactory sessionFactory;

    @Autowired
    public RatingDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Integer> getRatingMarks(String productName) {
        return currentSession().createQuery("select r.marks from Rating r where product.name=:productName")
                .setParameter("productName", productName)
                .list();
    }

    @Override
    public List<Rating> getAll() {
        return currentSession().createQuery("from Rating").list();
    }

    @Override
    public Rating getEntityById(Integer id) {
        return currentSession().get(Rating.class, id);
    }

    @Override
    public void add(Rating entity) {
        currentSession().save(entity);
    }

    @Override
    public void update(Rating entity) {
        currentSession().update(entity);
    }

    @Override
    public void delete(Integer id) {
        Rating product = (Rating) currentSession().get(Rating.class, id);
        if (product != null) currentSession().delete(product);
    }
}
