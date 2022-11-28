package com.example.java.multi_thread.book.java8_in_action.v2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BestPriceFinder {

    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                                   new Shop("LetsSaveBig"),
                                                   new Shop("MyFavoriteShop"),
                                                   new Shop("BuyItAll"),
                                                   new Shop("BuyItAll2"));
    private final Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        }
    });

    public List<String> findPricesSequential(String product) {
        return shops.stream()
                .map(shop -> shop.getPrice(product)) // delay
                .map(Quote::parse)
                .map(Discount::applyDiscount) // delay
                .collect(Collectors.toList());
    }

    public List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> priceFutures = findPricesStream(product)
                .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    // 비동기 2가 비동기 2에 영향을 받는다.
    private Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream()
                /*****************************비동기 1*****************************/
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor)) // I/O
                .map(future -> future.thenApply(Quote::parse)) // 동기
                /*****************************비동기 1*****************************/

                /*****************************비동기 2*****************************/
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor))); // I/O
                /*****************************비동기 2*****************************/
    }

}
