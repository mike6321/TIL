package com.example.webflux.service;

import com.example.webflux.dto.User;
import com.example.webflux.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.webflux.dto.User.createUser;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Mono<User> create(String name, String email) {
        User user = createUser(name, email);
        return userRepository.save(user);
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<Integer> deleteById(Long id) {
        return userRepository.deleteById(id);
    }

    public Mono<User> update(Long id, String name, String email) {
        return userRepository.findById(id)
                .flatMap(user -> {
                    user.setName(name);
                    user.setEmail(email);
                    return userRepository.save(user);
                });
    }

}
