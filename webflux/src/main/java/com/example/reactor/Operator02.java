package com.example.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

public class Operator02 {

    Flux<Integer> fluxConcatMap() {
        return Flux.range(1, 10)
                .concatMap(i -> Flux.range(i * 10, 10)
                        .delayElements(Duration.ofMillis(100)))
                .log();
    }

    Flux<Integer> monoFlatMapMany() {
        return Mono.just(10)
                .flatMapMany(i -> Flux.range(1, i))
                .log();
    }

    Mono<Integer> defaultIfEmpty() {
        return Mono.just(100)
                .filter(i -> i > 100)
                .defaultIfEmpty(30)
                .log();
    }

    Mono<Integer> switchIfEmpty() {
        return Mono.just(100)
                .filter(i -> i > 100)
                .switchIfEmpty(Mono.just(30).map(i -> i * 2))
                .log();
    }

    Mono<Integer> switchIfEmptyError() {
        return Mono.just(100)
                .filter(i -> i > 100)
                .switchIfEmpty(Mono.error(new RuntimeException()))
                .log();
    }

    Flux<String> fluxMerge() {
        return Flux.merge(
                Flux.fromIterable(List.of("1", "2", "3")), Flux.just("4")
                )
                .log();
    }

    Flux<String> monoMerge() {
        return Mono.just("1")
                .mergeWith(Mono.just("2"))
                .mergeWith(Mono.just("3"))
                .mergeWith(Mono.just("4"))
                .log();
    }

    Flux<String> fluxZip() {
        return Flux.zip(Flux.just("a", "b", "c"), Flux.just("d", "e", "f"))
                .map(i -> i.getT1() + i.getT2())
                .log();
    }

    Mono<String> monoZip() {
        return Mono.zip(Mono.just("a"), Mono.just("b"))
                .map(i -> i.getT1() + i.getT2())
                .log();
    }

}
