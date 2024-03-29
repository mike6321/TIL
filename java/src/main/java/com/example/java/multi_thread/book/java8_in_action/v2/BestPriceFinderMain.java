package com.example.java.multi_thread.book.java8_in_action.v2;

import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {

    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {
        /**
         * [BestPrice price is 73.36, LetsSaveBig price is 89.97, MyFavoriteShop price is 128.13, BuyItAll price is 122.69, BuyItAll2 price is 122.69]
         * sequential done in 40340583 msecs
         * */
        execute("sequential", () -> bestPriceFinder.findPricesSequential("IPhone14Pro"));
        /**
         * [BestPrice price is 77.81, LetsSaveBig price is 115.67, MyFavoriteShop price is 115.5, BuyItAll price is 112.9, BuyItAll2 price is 112.9]
         * composed CompletableFuture done in 42197581 msecs
         * */
        execute("composed CompletableFuture", () -> bestPriceFinder.findPricesFuture("IPhone14Pro"));
    }

    private static void execute(String msg, Supplier<List<String>> s) {
        long start = System.currentTimeMillis();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + " msecs");
    }

}
