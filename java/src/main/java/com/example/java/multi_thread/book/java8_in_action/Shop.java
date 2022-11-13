package com.example.java.multi_thread.book.java8_in_action;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.example.java.multi_thread.book.java8_in_action.Util.delay;

public class Shop {

    private final String name;
    private final Random random;

    public static void main(String[] args) {
        Shop shop = new Shop("junwoo-shop");

//        double shopPriceSync = shop.getPrice("product");
//        System.out.println(shopPriceSync);

        // 결과를 받을 때까지 Blocking 된 상태
        Future<Double> shopPriceAsync = shop.getPriceAsync("product");
        try {
            System.out.println(shopPriceAsync.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        doSomeThing();
    }

    private static void doSomeThing() {
        System.out.println("working...!");
    }

    public Shop(String name) {
        this.name = name;
        this.random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) * product.charAt(1);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();

        Thread thread = new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception e) {
                futurePrice.completeExceptionally(e);
            }
        });
        thread.setName("price-calculate-thread");
        thread.start();

        return futurePrice;
    }

}
