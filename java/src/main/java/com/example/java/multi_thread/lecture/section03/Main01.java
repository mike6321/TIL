package com.example.java.multi_thread.lecture.section03;

public class Main01 {

    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());
        thread.start();
        thread.interrupt();
    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                System.out.println("Exiting blocking thread.");
            }
        }

    }

}
