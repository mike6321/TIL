package com.example.webflux.repository;

import com.example.webflux.dto.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.Objects.isNull;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Map<Long, User> userMap = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1L);

    @Override
    public Mono<User> save(User user) {
        if (isNull(user.getId())) {
            user.setId(sequence.getAndAdd(1));
        }

        userMap.put(user.getId(), user);
        return Mono.just(user);
    }

    @Override
    public Flux<User> findAll() {
        return Flux.fromIterable(userMap.values());
    }

    @Override
    public Mono<User> findById(Long id) {
        return Mono.justOrEmpty(userMap.getOrDefault(id, null));

    }

    @Override
    public Mono<Integer> deleteById(Long id) {
        User user = userMap.getOrDefault(id, null);
        if (isNull(user)) {
            return Mono.just(0);
        }

        userMap.remove(id, user);
        return Mono.just(1);
    }

}
