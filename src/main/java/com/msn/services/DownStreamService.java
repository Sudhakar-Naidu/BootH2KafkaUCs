package com.msn.services;

import com.msn.pojos.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DownStreamService implements IDownStreamService {
    @Value("${topics.downstream}")
    private String downStreamTopic;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void publish(Order order) {
        this.kafkaTemplate.send(downStreamTopic, order.getOrderId().toString(), order);
    }
}
