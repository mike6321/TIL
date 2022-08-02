package com.example.java.multi_thread.section04;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

public class Example07 {

    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) throws InterruptedException {
        Executor executor = new Executor();
        executor.submit(new Job(4000));
        executor.submit(new Job(5000));
        executor.submit(new Job(3000));
    }

    @Slf4j
    static class Executor {

        public void submit(Job job) throws InterruptedException {
            log.info("Launching job : {}", job.getWork());
            semaphore.acquire();
            Thread thread = new Thread(() -> {
                try {
                    log.info("Executing job : {}", job.getWork());
                    Thread.sleep(job.getWork());
                    semaphore.release();
                    log.info("Job finished with id : {}", job.getWork());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }

    }

    static class Job {

        private final int work;

        public Job(int work) {
            this.work = work;
        }

        public int getWork() {
            return work;
        }

    }

}
