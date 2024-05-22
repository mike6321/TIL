package com.example.reactor;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Operator03Test {

    private final Operator03 operator03 = new Operator03();

    @Test
    void fluxCount() {
        StepVerifier.create(operator03.fluxCount())
                .expectNext(10l)
                .verifyComplete();
    }

    @Test
    void fluxDistinct() {
        StepVerifier.create(operator03.fluxDistinct())
                .expectNext(1, 2, 3)
                .verifyComplete();
    }

    @Test
    void fluxReduce() {
        StepVerifier.create(operator03.fluxReduce())
                .expectNext(55)
                .verifyComplete();
    }

    @Test
    void fluxGroupBy() {
        StepVerifier.create(operator03.fluxGroupBy())
                .expectNext(30)
                .expectNext(25)
                .verifyComplete();
    }

}