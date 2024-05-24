package com.example.webflux.controller;

import com.example.webflux.dto.UserCreateRequest;
import com.example.webflux.dto.UserResponse;
import com.example.webflux.dto.UserUpdateRequest;
import com.example.webflux.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public Mono<UserResponse> createUser(@RequestBody UserCreateRequest userCreateRequest) {
         return userService.create(userCreateRequest.getName(), userCreateRequest.getEmail())
                 .map(UserResponse::of);
    }

    @GetMapping
    public Flux<UserResponse> findAllUsers() {
        return userService.findAll()
                .map(UserResponse::of);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserResponse>> findUser(@PathVariable(name = "id") Long id) {
        return userService.findById(id)
                .map(user -> ResponseEntity.ok(UserResponse.of(user)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<?> deleteUser(@PathVariable(name = "id") Long id) {
        return userService.deleteById(id)
                .then(
                        Mono.just(ResponseEntity.noContent().build())
                );
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<UserResponse>> updateUser(@PathVariable(name = "id") Long id, @RequestBody UserUpdateRequest userUpdateRequest) {
        return userService.update(id, userUpdateRequest.getName(), userUpdateRequest.getEmail())
                .map(user -> ResponseEntity.ok(UserResponse.of(user)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
