package com.example.java.multi_thread.book.java8_in_action;

public class BestPriceFinderMain {

    public static void main(String[] args) {
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        // Done in 4031msecs
        long start = System.nanoTime();
        bestPriceFinder.findPrices("LetsSaveBig");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + "msecs");
    }

}
