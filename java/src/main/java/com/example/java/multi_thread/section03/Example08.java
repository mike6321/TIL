package com.example.java.multi_thread.section03;

import com.example.java.multi_thread.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Example08 {

    /**
     * Thread 클래스의 start() 메서드를 실행하게 되면
     * main Thread 가 혼자서 처리하는 run() 메서드와는 달리 생성된 Thread 가 Multi-Threading 으로 작업을 run 하게 된다.
     *
     * 아래 예시는 3개의 Thread 가 start() 이후 run() 에 포함되어있는 로직을 비순차적으로 처리하게 된다.
     * start 가 시작된 즉시 각각의 Thread 는 RUNNABLE 상태가 되어 병렬적으로 각자의 일을 처리한다.
     *
     *      >>>>>>>>>>>>>>>>>>>>>>>>>>>> after start (1) >>>>>>>>>>>>>>>>>>>>>>>>>>>>
     *      >>>>>>>>>>>>>>>>>>>>>>>>>>>> run start (1) >>>>>>>>>>>>>>>>>>>>>>>>>>>>
     *      14:14:11.887 [main] DEBUG com.example.java.multi_thread.util.ThreadUtil - [after start] - main : RUNNABLE
     *      14:14:11.890 [main] DEBUG com.example.java.multi_thread.util.ThreadUtil - [after start] - Thread-0 : RUNNABLE
     *      >>>>>>>>>>>>>>>>>>>>>>>>>>>> after start (1) >>>>>>>>>>>>>>>>>>>>>>>>>>>>
 *              >>>>>>>>>>>>>>>>>>>>>>>>>>>> after start (2) >>>>>>>>>>>>>>>>>>>>>>>>>>>>
     *      >>>>>>>>>>>>>>>>>>>>>>>>>>>> run start (1) >>>>>>>>>>>>>>>>>>>>>>>>>>>>
     *      14:14:11.887 [Thread-0] DEBUG com.example.java.multi_thread.util.ThreadUtil - [run start] - main : RUNNABLE
     *          14:14:11.891 [main] DEBUG com.example.java.multi_thread.util.ThreadUtil - [after start] - Thread-1 : RUNNABLE
     *      14:14:11.891 [Thread-0] DEBUG com.example.java.multi_thread.util.ThreadUtil - [run start] - Thread-0 : RUNNABLE
     *          >>>>>>>>>>>>>>>>>>>>>>>>>>>> run start (2) >>>>>>>>>>>>>>>>>>>>>>>>>>>>
     *          14:14:11.891 [Thread-1] DEBUG com.example.java.multi_thread.util.ThreadUtil - [run start] - Thread-1 : RUNNABLE
     *          14:14:11.891 [Thread-1] DEBUG com.example.java.multi_thread.util.ThreadUtil - [run start] - main : RUNNABLE
     *          14:14:11.891 [main] DEBUG com.example.java.multi_thread.util.ThreadUtil - [after start] - main : RUNNABLE
     *          14:14:11.891 [Thread-1] DEBUG com.example.java.multi_thread.util.ThreadUtil - [run start] - Thread-0 : TIMED_WAITING
     *          >>>>>>>>>>>>>>>>>>>>>>>>>>>> run start (2) >>>>>>>>>>>>>>>>>>>>>>>>>>>>
     *          14:14:11.891 [main] DEBUG com.example.java.multi_thread.util.ThreadUtil - [after start] - Thread-0 : TIMED_WAITING
     *          >>>>>>>>>>>>>>>>>>>>>>>>>>>> after start (2) >>>>>>>>>>>>>>>>>>>>>>>>>>>>
     *              >>>>>>>>>>>>>>>>>>>>>>>>>>>> after start (3) >>>>>>>>>>>>>>>>>>>>>>>>>>>>
     *              >>>>>>>>>>>>>>>>>>>>>>>>>>>> run start (3) >>>>>>>>>>>>>>>>>>>>>>>>>>>>
     *              14:14:11.891 [main] DEBUG com.example.java.multi_thread.util.ThreadUtil - [after start] - Thread-1 : TIMED_WAITING
     *              14:14:11.891 [main] DEBUG com.example.java.multi_thread.util.ThreadUtil - [after start] - Thread-2 : RUNNABLE
     *              14:14:11.891 [Thread-2] DEBUG com.example.java.multi_thread.util.ThreadUtil - [run start] - Thread-1 : TIMED_WAITING
     *              14:14:11.891 [main] DEBUG com.example.java.multi_thread.util.ThreadUtil - [after start] - main : RUNNABLE
     *              14:14:11.892 [Thread-2] DEBUG com.example.java.multi_thread.util.ThreadUtil - [run start] - Thread-2 : RUNNABLE
     *              14:14:11.892 [main] DEBUG com.example.java.multi_thread.util.ThreadUtil - [after start] - Thread-0 : TIMED_WAITING
     *              >>>>>>>>>>>>>>>>>>>>>>>>>>>> after start (3) >>>>>>>>>>>>>>>>>>>>>>>>>>>>
     *              14:14:11.892 [Thread-2] DEBUG com.example.java.multi_thread.util.ThreadUtil - [run start] - main : RUNNABLE
 *                  14:14:11.892 [Thread-2] DEBUG com.example.java.multi_thread.util.ThreadUtil - [run start] - Thread-0 : TIMED_WAITING
     *              >>>>>>>>>>>>>>>>>>>>>>>>>>>> run start (3) >>>>>>>>>>>>>>>>>>>>>>>>>>>>
     * Total = 3
     * */
    private static int globalCounter = 0; // heap memory

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        ThreadGroup threadGroup = new ThreadGroup("threadGroup-01");
        for (int i = 1; i <= 3; i++) {
            Thread thread = new Thread(threadGroup, new MyThread());
            thread.start();
            threads.add(thread);
            ThreadUtil.getThreadInfo("after start");
        }
        quitThreadGroup(threads, threadGroup);
        System.out.println("Total = " + globalCounter);
    }

    private static void quitThreadGroup(List<Thread> threads, ThreadGroup threadGroup) {
        threadGroup.interrupt();
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
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
