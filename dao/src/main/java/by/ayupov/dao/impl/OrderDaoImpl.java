package by.ayupov.dao.impl;

import by.ayupov.entity.Order;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

@NoArgsConstructor
public class OrderDaoImpl extends BaseDaoImpl<Order> {
    private static final Logger log = Logger.getLogger(OrderDaoImpl.class);
    private static OrderDaoImpl orderDao;

    public static OrderDaoImpl getInstance() {
        if (orderDao == null) {
            orderDao = new OrderDaoImpl();
        }
        return orderDao;
    }
}
