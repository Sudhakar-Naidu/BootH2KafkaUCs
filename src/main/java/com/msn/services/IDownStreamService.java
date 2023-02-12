package com.msn.services;

import com.msn.pojos.Order;

public interface IDownStreamService {
    void publish(Order order);
}
