package com.example.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Publisher {

    Flux<Integer> startFlux() {
        return Flux.range(1, 10)
                .log();
    }

    Mono<Integer> startMono() {
        return Mono.just(1)
                .log();
    }

    Mono<?> startEmptyMono() {
        return Mono.empty()
                .log();
    }

    Mono<?> startErrorMono() {
        return Mono.error(new RuntimeException("error!!!"))
                .log();
    }

}
