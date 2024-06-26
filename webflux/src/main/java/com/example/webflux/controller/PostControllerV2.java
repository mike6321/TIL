package com.example.webflux.controller;

import com.example.webflux.dto.PostCreateRequest;
import com.example.webflux.dto.PostResponseV2;
import com.example.webflux.service.PostServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v2/posts")
public class PostControllerV2 {

    private final PostServiceV2 postServiceV2;

    @PostMapping
    public Mono<PostResponseV2> createPost(@RequestBody PostCreateRequest request) {
        return postServiceV2.create(request.getUserId(), request.getTitle(), request.getContent())
                .map(PostResponseV2::of);
    }

    @GetMapping
    public Flux<PostResponseV2> findAllPosts() {
        return postServiceV2.findAll()
                .map(PostResponseV2::of);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<PostResponseV2>> findPost(@PathVariable(value = "id") Long id) {
        return postServiceV2.findById(id)
                .map(post -> ResponseEntity.ok().body(PostResponseV2.of(post)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<PostResponseV2>> deletePost(@PathVariable(value = "id") Long id) {
        return postServiceV2.deleteById(id)
                .then(Mono.just(ResponseEntity.notFound().build()));
    }

}
