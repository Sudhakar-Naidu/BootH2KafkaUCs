package com.msn.services;

import com.msn.pojos.Order;

public interface IUpStreamService {
    void publish(Integer count);

    void consumeAndPersist(Order order);
}
