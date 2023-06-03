package com.alpha.activemqdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final JmsTemplate jmsTemplate;

    @PostMapping("/")
    public String hello(@RequestBody String greeting) {

        jmsTemplate.convertAndSend("hello", greeting);
        return "Hello World!";
    }
}
