package com.example.kafka.references.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final Sender sender;

    @PostMapping("send")
    public void send(@RequestBody String message) {
        sender.unUsedKeySend(message);
    }

}
