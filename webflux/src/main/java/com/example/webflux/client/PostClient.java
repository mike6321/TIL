package com.example.webflux.client;

import com.example.webflux.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class PostClient {

    private final WebClient webClient;
    private final String URL = "http://127.0.0.1:8090";

    // webClient -> mvc("/posts/{id}")
    public Mono<PostResponse> getPost(Long id) {
        String uriString = UriComponentsBuilder.fromHttpUrl(URL)
                .path("/posts/%d".formatted(id))
                .buildAndExpand()
                .toUriString();

        return webClient.get()
                .uri(uriString)
                .retrieve()
                .bodyToMono(PostResponse.class);
    }

}
