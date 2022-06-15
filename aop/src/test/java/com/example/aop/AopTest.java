package com.example.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopTest {

    @Autowired
    EventService eventService;

    @Test
    void aop_test() {
        eventService.createEvent();
        eventService.publishEvent();
        eventService.deleteEvent();
    }

}
