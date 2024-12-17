package com.example.designpattern.decoratorpattern._03_with_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Client client = applicationContext.getBean(Client.class);

        client.writeComment("Hello, http://www.example.com");
        client.writeComment("choijunwoo...");
    }

}
