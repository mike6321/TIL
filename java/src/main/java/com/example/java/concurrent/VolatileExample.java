package com.example.java.concurrent;

public class VolatileExample {

    static class WorkerThread implements Runnable {
        private boolean running = true;

        @Override
        public void run() {
            while (running) {
                // 작업 수행
                System.out.println("Worker is running...");

                try {
                    Thread.sleep(1000); // 1초 대기
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Worker stopped.");
        }

        public void stop() {
            running = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WorkerThread worker = new WorkerThread();
        Thread thread = new Thread(worker);
        thread.start();

        Thread.sleep(3000); // 메인 스레드는 3초 동안 대기

        // Worker 스레드를 멈춤
        worker.stop();
        if (thread.isAlive()) {
            System.out.println("The worker thread is still running.");
        } else {
            System.out.println("The worker thread has stopped.");
        }
    }
}

