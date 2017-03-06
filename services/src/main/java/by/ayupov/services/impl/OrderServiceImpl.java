package by.ayupov.services.impl;

import by.ayupov.dao.interfaces.OrderDao;
import by.ayupov.entity.Order;
import by.ayupov.services.interfaces.OrderService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link OrderService} interface
 *
 * @author Vadim Ayupov
 */
@Service
@Log
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    @Transactional
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    @Transactional
    public Order getEntityById(Integer id) {
        return orderDao.getEntityById(id);
    }

    @Override
    @Transactional
    public void add(Order entity) {
        orderDao.add(entity);
    }

    @Override
    @Transactional
    public void update(Order entity) {
        orderDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        orderDao.delete(id);
    }
}
