package com.msn.controllers;

import com.msn.pojos.Order;
import com.msn.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/")
    public String message() {
        return "OrderController Message";
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return new ResponseEntity<Order>(orderService.createOrder(order), HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> findAllOrders() {
        return ResponseEntity.ok().body(orderService.findAllOrders());
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Order> findByOrderId(@PathVariable(value = "orderId") Long orderId) {
//        Order order = orderService.findByOrderId(orderId).orElseThrow(() -> new NoResourceException("Order Doesn't Exist"));
        return new ResponseEntity<Order>(orderService.findByOrderId(orderId), HttpStatus.OK);
    }

}
