package com.example.java.multi_thread.book.java8_in_action.v1;

public class BestPriceFinderMain {

    public static void main(String[] args) {
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors = " + availableProcessors);
        // Done in 4031msecs
        sequentialExecute(bestPriceFinder);
        // Done in 1010msecs
        parallelStreamExecute(bestPriceFinder);
        // Done in 1007msecs
        completableFutureExecute(bestPriceFinder);
        completableFutureWithExecutorExecute(bestPriceFinder);
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

    private static void completableFutureExecute(BestPriceFinder bestPriceFinder) {
        long start = System.nanoTime();
        bestPriceFinder.findPricesCompletableFuture("LetsSaveBig");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + "msecs");
    }
    private static void completableFutureWithExecutorExecute(BestPriceFinder bestPriceFinder) {
        long start = System.nanoTime();
        bestPriceFinder.findPricesCompletableWithExecutorFuture("LetsSaveBig");
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + "msecs");
    }

}
