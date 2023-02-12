package com.msn.services;

import com.msn.pojos.Order;
import com.msn.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class UpStreamService implements IUpStreamService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Value("${topics.upstream}")
    private String upStreamTopic;

    @Override
    public void publish(Integer count) {
        IntStream.range(0, count)
                .forEach(i -> this.kafkaTemplate.send(upStreamTopic, String.valueOf(i),
                                Order.builder().message(String.format("Message Count : %s", i)).status("Ordered").build()
                        )
                );
    }

    @Override
    @KafkaListener(topics = "${topics.upstream}", containerFactory = "concurrentKafkaListenerContainerFactory", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeAndPersist(Order order) {
        System.out.println(":::::::::::::CONSUMING & SAVING MESSAGE to Database::::::" + order);
        orderRepository.saveAndFlush(order);
    }
}
