package com.alpha.activemqdemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class ActiveMqConfig {



//    @Bean
//    public ConnectionFactory connectionFactory() throws JMSException {
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
//        connectionFactory.setBrokerURL("tcp://localhost:61616");
//        return connectionFactory;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setConnectionFactory(connectionFactory);
//        return jmsTemplate;
//    }
//
//    @Bean
//    public JmsListenerContainerFactory<?> queueListenerContainerFactory() throws JMSException {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory());
//        factory.setMessageConverter(messageConverter());
//        return factory;
//    }

//    @Bean
//    public MessageConverter messageConverter(){
//
//        MappingJackson2MessageConverter converter =new MappingJackson2MessageConverter();
//        converter.setObjectMapper(objectMapper());
//        converter.setTargetType(MessageType.TEXT);
////        converter.setTypeIdPropertyName("_type");
//        return converter;
//
//    }
//    public ObjectMapper objectMapper() {
//        return new ObjectMapper();
//    }

}
