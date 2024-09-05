package com.example.spring_integration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IntegrationConfig.class);

        DirectChannel inputChannel = context.getBean("inputChannel", DirectChannel.class);

        Message<String> message = MessageBuilder.withPayload("Hello, Spring Integration!").build();
        inputChannel.send(message);

        context.close();


    }
}
