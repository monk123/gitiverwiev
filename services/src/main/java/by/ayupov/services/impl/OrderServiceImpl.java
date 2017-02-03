package by.ayupov.services.impl;

import by.ayupov.entity.Order;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> {
    private static final Logger log = Logger.getLogger(OrderServiceImpl.class);
}
