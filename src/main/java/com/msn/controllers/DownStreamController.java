package com.msn.controllers;

import com.msn.pojos.Order;
import com.msn.services.IDownStreamService;
import com.msn.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/downstream")
public class DownStreamController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IDownStreamService downStreamService;

    @GetMapping("/")
    public String message() {
        return "From DownStreamController";
    }

    @GetMapping("/publish/{orderId}")
    public ResponseEntity<String> publish(@PathVariable(value = "orderId") Long orderId) {
        Order order = orderService.findByOrderId(orderId);
        order.setMessage(order.getMessage() + " - Transformed Messaged : Order is completed...");
        order.setStatus("Completed");
        downStreamService.publish(order);
        return new ResponseEntity<String>("Messages Successfully Published to DownStream Topic", HttpStatus.OK);
    }
}
