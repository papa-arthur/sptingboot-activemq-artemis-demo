package com.alpha.activemqdemo.controller;

import com.alpha.activemqdemo.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.JMSException;
import jakarta.jms.Queue;
import jakarta.jms.TextMessage;
import jakarta.jms.Topic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OderController {

    private final JmsTemplate jmsTemplate;

    @PostMapping("/order")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) throws JMSException {
        log.info("Sending order: {}", order);

        Queue orderQueue = jmsTemplate.getConnectionFactory().createConnection()
                .createSession().createQueue("order-queue");
        jmsTemplate.send(orderQueue, s -> {
            TextMessage tm = null;
            try {
                tm = s.createTextMessage(new ObjectMapper().writeValueAsString(order));
                tm.setJMSType(Order.class.getTypeName());
                tm.setStringProperty("orderType", Order.class.getTypeName());
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return tm;
        });


//===================================================================
        Topic orderTopic = jmsTemplate.getConnectionFactory().createConnection()
                .createSession().createTopic("order-topic");
        log.info("Sending order to EmpTopic: {}", order);
        jmsTemplate.send(orderTopic, s -> {
            TextMessage tm = null;
            try {
                tm = s.createTextMessage(new ObjectMapper().writeValueAsString(order));
                tm.setJMSType(Order.class.getTypeName());
                tm.setStringProperty("orderType", Order.class.getTypeName());
                return tm;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        return ResponseEntity.ok(order);
    }
}
