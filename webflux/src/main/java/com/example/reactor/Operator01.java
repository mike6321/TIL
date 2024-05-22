package com.example.reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Operator01 {

    Flux<Integer> fluxMap() {
        return Flux.range(1, 5)
                .map(i -> i * 2)
                .log();
    }

    Flux<Integer> fluxFilter() {
        return Flux.range(1, 5)
                .filter(i -> i >= 5)
                .log();
    }

    Flux<Integer> fluxFilterTake() {
        return Flux.range(1, 10)
                .filter(i -> i > 5)
                .take(3)
                .log();
    }

    Flux<Integer> fluxFlatMap01() {
        return Flux.range(1, 10)
                .flatMap(i -> Flux.range(i * 10, 10)
                        .delayElements(Duration.ofMillis(100)))
                .log();
    }

    Flux<Integer> fluxFlatMap02() {
        return Flux.range(1, 9)
                .flatMap(i -> Flux.range(1, 9)
                        .map(j -> {
                            System.out.printf("%d * %d = %d \n", i, j, i * j);
                            return i * j;
                        })
                );
    }

}
