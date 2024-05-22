package com.example.reactor;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class Operator04Test {

    private final Operator04 operator04 = new Operator04();

    @Test
    void fluxDelayAndLimit() {
        StepVerifier.create(operator04.fluxDelayAndLimit())
                .expectNext(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .verifyComplete();
    }

    @Test
    void fluxSample() {
        StepVerifier.create(operator04.fluxSample())
                .expectNext(100)
                .verifyComplete();
    }

}