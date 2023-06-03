package com.alpha.activemqdemo.controller;

import com.alpha.activemqdemo.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OderController {

    private final JmsTemplate jmsTemplate;
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {

        return ResponseEntity.ok(order);
    }
}
