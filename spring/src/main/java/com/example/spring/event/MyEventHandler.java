package com.example.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class MyEventHandler {

    @EventListener
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public void onApplicationEvent(MyEvent event) {
        System.out.println(Thread.currentThread());
        System.out.println("이벤트를 받았다. 데이터는 " + event.getData());
    }

}
