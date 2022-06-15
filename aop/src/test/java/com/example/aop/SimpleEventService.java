package com.example.aop;

import org.springframework.stereotype.Service;

@Service
public class SimpleEventService implements EventService {

    @Override
    @PerfLogging
    public void createEvent() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("createEvent");
    }

    @Override
    public void publishEvent() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("publishEvent");
    }

    @Override
    @PerfLogging
    public void deleteEvent() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("deletedEvent");
    }

}
