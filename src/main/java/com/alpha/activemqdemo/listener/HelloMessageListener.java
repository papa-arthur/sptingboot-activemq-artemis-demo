package com.alpha.activemqdemo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HelloMessageListener {

    @JmsListener(destination = "hello")
    public void onMessage(String message) {
        log.info("Received message: {}", message);

    }




}
