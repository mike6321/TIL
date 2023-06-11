package com.example.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnotherHandler {

    @EventListener
    public void handle(MyEvent myEvent) {
        System.out.println(Thread.currentThread());
        System.out.println("(Another) 이벤트를 받았다. 데이터는 " + myEvent.getData());
    }

}
