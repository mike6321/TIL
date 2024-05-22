package com.example.reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Operator04 {

    Flux<Integer> fluxDelayAndLimit() {
        return Flux.range(1, 10)
                .delaySequence(Duration.ofSeconds(1))
                .log()
                .limitRate(2);
    }

    Flux<Integer> fluxSample() {
        return Flux.range(1, 100)
                .delaySequence(Duration.ofMillis(100))
                .sample(Duration.ofMillis(300))
                .log();
    }

}
