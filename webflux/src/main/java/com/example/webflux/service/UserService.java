package com.example.webflux.service;

import com.example.webflux.dto.User;
import com.example.webflux.repository.UserR2dbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.webflux.dto.User.createUser;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserR2dbcRepository userR2dbcRepository;

    public Mono<User> create(String name, String email) {
        User user = createUser(name, email);
        return userR2dbcRepository.save(user);
    }

    public Flux<User> findAll() {
        Flux<User> all = userR2dbcRepository.findAll();
        return all;
    }

    public Mono<User> findById(Long id) {
        return userR2dbcRepository.findById(id);
    }

    public Mono<Void> deleteById(Long id) {
        return userR2dbcRepository.deleteById(id);
    }

    public Mono<User> update(Long id, String name, String email) {
        return userR2dbcRepository.findById(id)
                .flatMap(user -> {
                    user.setName(name);
                    user.setEmail(email);
                    return userR2dbcRepository.save(user);
                });
    }

}
