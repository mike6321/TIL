package com.example.java.multi_thread.book.java8_in_action;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class BestPriceFinder {

    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                                   new Shop("LetsSaveBig"),
                                                   new Shop("MyFavoriteShop"),
                                                   new Shop("BuyItAll"));

    public List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPricesParallelStream(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPricesCompletableFuture(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop ->
                        CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                )
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join) // 모든 비동기 요청이 끝나길 기다린다.
                .collect(Collectors.toList());
    }

}
