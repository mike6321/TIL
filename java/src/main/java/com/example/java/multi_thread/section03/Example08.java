package com.example.java.multi_thread.section03;

import com.example.java.multi_thread.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Example08 {

    private static int globalCounter = 0; // heap memory

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        ThreadGroup threadGroup = new ThreadGroup("threadGroup-01");
        for (int i = 1; i <= 3; i++) {
            Thread thread = new Thread(threadGroup, new MyThread());
//            ThreadUtil.getThreadInfo("before start");
            thread.start();
            ThreadUtil.getThreadInfo("after start");
            threads.add(thread);
        }
//        threadGroup.interrupt();

        threads.forEach(thread -> {
            try {
                log.info("before join");
                thread.join();
                log.info("after join");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Total = " + globalCounter);
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            ThreadUtil.getThreadInfo("run start");
            try {
                Thread.sleep(99999);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }

            globalCounter++;
        }

    }

}
