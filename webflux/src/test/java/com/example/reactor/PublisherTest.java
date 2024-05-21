package com.example.reactor;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class PublisherTest {

    private final Publisher publisher = new Publisher();

    @Test
    void startFluxTest() {
        StepVerifier.create(publisher.startFlux())
                .expectNext(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .verifyComplete();
    }

    @Test
    void startMonoTest() {
        StepVerifier.create(publisher.startMono())
                .expectNext(1)
                .verifyComplete();
    }

    @Test
    void startEmptyMonoTest() {
        StepVerifier.create(publisher.startEmptyMono())
                .verifyComplete();
    }

    @Test
    void startErrorMonoTest() {
        StepVerifier.create(publisher.startErrorMono())
                .expectError(RuntimeException.class)
                .verify();
    }

}