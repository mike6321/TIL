package com.example.reactor;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class Operator02Test {

    private final Operator02 operator02 = new Operator02();

    @Test
    void fluxConcatMapTest() {
        StepVerifier.create(operator02.fluxConcatMap())
                .expectNextCount(100)
                .verifyComplete();
    }

    @Test
    void monoFlatMapMany() {
        StepVerifier.create(operator02.monoFlatMapMany())
                .expectNextCount(10)
                .verifyComplete();
    }

    @Test
    void defaultIfEmpty() {
        StepVerifier.create(operator02.defaultIfEmpty())
                .expectNext(30)
                .verifyComplete();
    }

    @Test
    void switchIfEmpty() {
        StepVerifier.create(operator02.switchIfEmpty())
                .expectNext(60)
                .verifyComplete();
    }

    @Test
    void switchIfEmptyError() {
        StepVerifier.create(operator02.switchIfEmptyError())
                .expectError(RuntimeException.class)
                .verify();
    }

    @Test
    void fluxMerge() {
        StepVerifier.create(operator02.fluxMerge())
                .expectNext("1", "2", "3", "4")
                .verifyComplete();
    }

    @Test
    void monoMerge() {
        StepVerifier.create(operator02.monoMerge())
                .expectNext("1", "2", "3", "4")
                .verifyComplete();
    }

    @Test
    void fluxZip() {
        StepVerifier.create(operator02.fluxZip())
                .expectNext("ad", "be", "cf")
                .verifyComplete();
    }

    @Test
    void monoZip() {
        StepVerifier.create(operator02.monoZip())
                .expectNext("ab")
                .verifyComplete();
    }

}