package com.example.java.multi_thread.book.java8_in_action;

public class BestPriceFinderMain {

    public static void main(String[] args) {
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        // Done in 4031msecs
        sequentialExecute(bestPriceFinder);
        // Done in 1010msecs
        parallelStreamExecute(bestPriceFinder);
    }

    private static void sequentialExecute(BestPriceFinder bestPriceFinder) {
        long start = System.nanoTime();
        bestPriceFinder.findPrices("LetsSaveBig");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + "msecs");
    }

    private static void parallelStreamExecute(BestPriceFinder bestPriceFinder) {
        long start = System.nanoTime();
        bestPriceFinder.findPricesParallelStream("LetsSaveBig");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + "msecs");
    }

}
