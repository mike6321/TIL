package com.example.java.multi_thread.lecture.section05;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

        // step01
//        incrementingThread.start();
//        incrementingThread.join();
//
//        decrementingThread.start();
//        decrementingThread.join();

        // step02
        incrementingThread.start();
        decrementingThread.start();

        incrementingThread.join();
        decrementingThread.join();

        System.out.println("We Currently have " + inventoryCounter.getItems() + " items.");
    }

    public static class IncrementingThread extends Thread {

        private final InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            IntStream.range(0, 10000)
                    .forEach(index -> inventoryCounter.increment());
        }

    }

    public static class DecrementingThread extends Thread {

        private final InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            IntStream.range(0, 10000)
                    .forEach(index -> inventoryCounter.decrement());
        }

    }

    private static class InventoryCounter {

        private int items = 0;

        public void increment() {
            items++;
        }

        public void decrement() {
            items--;
        }

        public int getItems() {
            return items;
        }

    }

}
