package com.example.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class AsynchronousExample {

    public static final Logger log = LoggerFactory.getLogger(AsynchronousExample.class.getName());

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.naver.com"))
                .build();

        CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        log.info("This is Next ...");

        future.thenApply(HttpResponse::body)
                .thenAccept(log::info)
                .join();
    }

}
