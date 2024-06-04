package com.example.webflux.repository;

import com.example.webflux.dto.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Deprecated
public interface UserRepository {

    Mono<User> save(User user);

    Flux<User> findAll();

    Mono<User> findById(Long id);

    Mono<Integer> deleteById(Long id);

}
