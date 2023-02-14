package com.example.kafka.references.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver {

    @KafkaListener(topics = {"${spring.kafka.topic1}", "${spring.kafka.topic2}"})
    public void listen(String in) {
        log.info("***********************************");
        log.info("{}", in);
        log.info("***********************************");
    }

}
