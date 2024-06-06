package com.example.webflux.service;

import com.example.webflux.dto.User;
import com.example.webflux.repository.UserR2dbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static com.example.webflux.dto.User.createUser;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserR2dbcRepository userR2dbcRepository;
    private final ReactiveRedisTemplate<String, User> reactiveRedisTemplate;

    public Mono<User> create(String name, String email) {
        User user = createUser(name, email);
        return userR2dbcRepository.save(user);
    }

    public Flux<User> findAll() {
        return userR2dbcRepository.findAll();
    }

    public Mono<User> findById(Long id) {
        // 1. redis 조회
        // 2. 값이 존재하면 응답을 하고
        // 3. 없으면 DB 에 질의하고 그결과를 redis 에 저장
        return reactiveRedisTemplate.opsForValue()
                .get(getCachedKey(id))
                .switchIfEmpty(
                        userR2dbcRepository.findById(id)
                                .flatMap(user -> reactiveRedisTemplate.opsForValue()
                                        .set(getCachedKey(id), user, Duration.ofSeconds(30))
                                        .then(Mono.just(user)))
                );
    }

    public Mono<Void> deleteById(Long id) {
        return userR2dbcRepository.deleteById(id)
                .then(reactiveRedisTemplate.unlink(getCachedKey(id)))
                .then(Mono.empty());
    }

    public Mono<Void> deleteByName(String name) {
        return userR2dbcRepository.deleteByName(name);
    }

    public Mono<User> update(Long id, String name, String email) {
        return userR2dbcRepository.findById(id)
                .flatMap(user -> {
                    user.setName(name);
                    user.setEmail(email);
                    return userR2dbcRepository.save(user);
                })
                .flatMap(user -> reactiveRedisTemplate.unlink(getCachedKey(id)).then(Mono.just(user)));
    }

    public String getCachedKey(Long id) {
        return "users:%d".formatted(id);
    }

}
