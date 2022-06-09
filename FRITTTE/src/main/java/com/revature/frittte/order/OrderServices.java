package com.revature.frittte.order;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderServices {

    private OrderDao orderDao;

    @Autowired // not really necessary, but good practice
    public OrderServices(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderData create(OrderData newOrder) {

        OrderData persistedOrder = orderDao.save(newOrder);
        return persistedOrder;
    }
}
