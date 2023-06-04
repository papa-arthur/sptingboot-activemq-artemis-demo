package com.alpha.activemqdemo.listener;

import com.alpha.activemqdemo.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderMessageListener {

    @JmsListener(destination = "order-queue", containerFactory = "queueFactory")
    public void receiveMessage(@Payload Order order) {
        log.info("Received message order-queue: {}", order);
    }

    @JmsListener(destination = "order-topic", containerFactory = "topicFactory")
    public void topicListener1(@Payload Order order) {
        log.info("Listener1: Received message from EmpTopic: {}", order);
    }

    @JmsListener(destination = "order-topic", containerFactory = "topicFactory")
    public void topicListener2(@Payload Order order) {
        log.info("Listener2: Received message from EmpTopic: {}", order);
    }
}
