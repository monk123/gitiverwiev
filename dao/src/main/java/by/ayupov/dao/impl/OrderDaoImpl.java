package by.ayupov.dao.impl;

import by.ayupov.dao.interfaces.OrderDao;
import by.ayupov.entity.Order;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of {@link OrderDao} interface
 *
 * @author Vadim Ayupov
 */
@Repository
@Log
public class OrderDaoImpl implements OrderDao {
    private SessionFactory sessionFactory;

    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Order> getAll() {
        return currentSession().createQuery("from Order").list();
    }

    @Override
    public Order getEntityById(Integer id) {
        return currentSession().get(Order.class, id);
    }

    @Override
    public void add(Order entity) {
        currentSession().save(entity);
    }

    @Override
    public void update(Order entity) {
        currentSession().update(entity);
    }

    @Override
    public void delete(Integer id) {
        Order order = (Order) currentSession().get(Order.class, id);
        if (order != null) currentSession().delete(order);
    }
}
