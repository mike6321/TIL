package com.example.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Operator03 {

    Mono<Long> fluxCount() {
        return Flux.range(1, 10)
                .count()
                .log();
    }

    Flux<Integer> fluxDistinct() {
        return Flux.fromIterable(List.of(1, 1, 2, 3))
                .distinct()
                .log();
    }

    Mono<Integer> fluxReduce() {
        return Flux.range(1, 10)
                .reduce(Integer::sum)
                .log();
    }

    Flux<Integer> fluxGroupBy() {
        return Flux.range(1, 10)
                .groupBy(i -> i % 2 == 0 ? "even" : "odd")
                .flatMap(group -> group.reduce(Integer::sum))
                .log();
    }

}
