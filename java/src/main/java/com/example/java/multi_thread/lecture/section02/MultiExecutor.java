package com.example.java.multi_thread.lecture.section02;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {

    private List<Runnable> tasks;

    public MultiExecutor(List<Runnable> tasks) {
        // Complete your code here
        this.tasks = tasks;
    }

    public void executeAll() {
        // complete your code here
        List<Thread> threads = new ArrayList<>();
        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

    }

}
