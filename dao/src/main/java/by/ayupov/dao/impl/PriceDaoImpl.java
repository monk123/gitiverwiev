package by.ayupov.dao.impl;

import by.ayupov.dao.interfaces.PriceDao;
import by.ayupov.entity.Price;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Implementation of {@link PriceDao} interface
 *
 * @author Vadim Ayupov
 */
@Repository
@Log
public class PriceDaoImpl implements PriceDao {
    private SessionFactory sessionFactory;

    @Autowired
    public PriceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Price> paginationPrice(int pageNumber, int page) {
        return currentSession().createQuery("from Price", Price.class)
                .setFirstResult(pageNumber)
                .setMaxResults(page)
                .list();
    }

    @Override
    public List<Price> getAll() {
        return currentSession().createQuery("from Price").list();
    }

    @Override
    public Price getEntityById(Integer id) {
        return currentSession().get(Price.class, id);
    }

    @Override
    public void add(Price entity) {
        currentSession().save(entity);
    }

    @Override
    public void update(Price entity) {
        currentSession().update(entity);
    }

    @Override
    public void delete(Integer id) {
        Price price = (Price) currentSession().get(Price.class, id);
        if (price != null) currentSession().delete(price);
    }
}