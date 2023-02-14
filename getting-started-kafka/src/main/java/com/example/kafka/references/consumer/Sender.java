package com.example.kafka.references.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Sender {

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    public void unUsedKeySend(final String payload) {
        log.info("sending payload : {}", payload);
        kafkaTemplate.send("topic01", payload);
        kafkaTemplate.send("topic02", payload);

        kafkaTemplate.send("topic01", payload);
    }

}
