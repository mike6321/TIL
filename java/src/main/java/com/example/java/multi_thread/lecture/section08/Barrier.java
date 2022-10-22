package com.example.java.multi_thread.lecture.section08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 세마포어를 0으로 초기화해서, 세마포어를 획득하려는 모든 스레드가 블록될 수 있도록 한다.
 * 그리고 "numberOfWorkers - 1" 스레드는 세마포어에서 블록된 상태이므로, barrier에 도달한 마지막 스레드가 numberOfWorkers - 1 세마포어를 릴리스
 * */
public class Barrier {

    private final int numberOfWorkers;
    private Semaphore semaphore = new Semaphore(0);
    private int counter = 0;
    private Lock lock = new ReentrantLock();

    public static void main(String [] args){
        int numberOfThreads = 1000; //or any number you'd like

        List<Thread> threads = new ArrayList<>();

        Barrier barrier = new Barrier(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            threads.add(new Thread(new CoordinatedWorkRunner(barrier)));
        }

        for(Thread thread: threads) {
            thread.start();
        }
    }

    public Barrier(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public void barrier() {
        lock.lock();
        boolean isLastWorker = false;
        try {
            counter++;

            if (counter == numberOfWorkers) {
                isLastWorker = true;
            }
        } finally {
            lock.unlock();
        }


        if (isLastWorker) {
            semaphore.release(numberOfWorkers - 1); // 마지막 쓰레드인 경우에는 semaphore 를 풀어준다.
        } else {
            try {
                semaphore.acquire(); // 마지막 쓰레드가 아닌경우에는 semaphore 를 잡고 있는다. TASK1 전부 실행
            } catch (InterruptedException e) {
            }
        }
    }

    public static class CoordinatedWorkRunner implements Runnable {
        private Barrier barrier;

        public CoordinatedWorkRunner(Barrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                task();
            } catch (InterruptedException e) {
            }
        }

        private void task() throws InterruptedException {
            // Performing Part 1
            System.out.println(Thread.currentThread().getName()
                    + " part 1 of the work is finished");

            barrier.barrier();

            // Performing Part2
            System.out.println(Thread.currentThread().getName()
                    + " part 2 of the work is finished");
        }
    }

}
