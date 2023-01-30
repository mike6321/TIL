package com.example.kafka.references.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Sender {

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    public void send(final String payload) {
        log.info("sending payload : {}", payload);
        kafkaTemplate.send("topic0", payload);
    }

}
