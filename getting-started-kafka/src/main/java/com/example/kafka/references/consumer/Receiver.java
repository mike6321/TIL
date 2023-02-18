package com.example.kafka.references.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver {

    @KafkaListener(topics = {"${spring.kafka.topic1}", "${spring.kafka.topic2}", "${spring.kafka.topic3}", "${spring.kafka.topic4}"})
    public void listen01(String in) {
        log.info("***********************************");
        log.info("{}", in);
        log.info("***********************************");
    }

    @KafkaListener(topics = {"${spring.kafka.topic1}", "${spring.kafka.topic2}", "${spring.kafka.topic3}", "${spring.kafka.topic4}"})
    public void listen02(String in) {
        log.info("***********************************");
        log.info("{}", in);
        log.info("***********************************");
    }

}
