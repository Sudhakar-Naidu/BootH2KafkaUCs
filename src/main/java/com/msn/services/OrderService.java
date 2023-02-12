package com.msn.services;

import com.msn.miscellaneous.NoResourceException;
import com.msn.pojos.Order;
import com.msn.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order findByOrderId(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new NoResourceException("Order Doesn't Exist"));
//        return orderRepository.findById(orderId);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.saveAndFlush(order);
    }
}
