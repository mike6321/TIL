package com.example.reactor;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class Operator01Test {

    private final Operator01 operator01 = new Operator01();

    @Test
    void mapTest() {
        StepVerifier.create(operator01.fluxMap())
                .expectNext(2, 4, 6, 8, 10)
                .verifyComplete();
    }

    @Test
    void filterTest() {
        StepVerifier.create(operator01.fluxFilter())
                .expectNext(5)
                .verifyComplete();
    }

    @Test
    void takeTest() {
        StepVerifier.create(operator01.fluxFilterTake())
                .expectNext(6, 7, 8)
                .verifyComplete();
    }

    @Test
    void FlatMapTest01() {
        StepVerifier.create(operator01.fluxFlatMap01())
                .expectNextCount(100)
                .verifyComplete();
    }

    @Test
    void FlatMapTest02() {
        StepVerifier.create(operator01.fluxFlatMap02())
                .expectNextCount(81)
                .verifyComplete();
    }

}