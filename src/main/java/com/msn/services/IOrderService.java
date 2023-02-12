package com.msn.services;

import com.msn.pojos.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAllOrders();

    //    Optional<Order> findByOrderId(Long orderId);
    Order findByOrderId(Long orderId);

    Order createOrder(Order order);
}
