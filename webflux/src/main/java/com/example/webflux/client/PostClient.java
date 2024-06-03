package com.example.webflux.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PostClient {

    private final WebClient webClient;
    private final String URL = "http://127.0.0.1:8090";

    public Mono<?> getPost(Long id) {
        UriComponents build = UriComponentsBuilder.fromHttpUrl(URL)
                .path("/posts")
                .build();
        return null;
    }

}
