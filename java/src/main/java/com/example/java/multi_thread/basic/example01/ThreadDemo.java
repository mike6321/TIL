package com.example.java.multi_thread.basic.example01;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo( String name) {
        threadName = name;
        log.debug("Creating {}", threadName);
    }

    @Override
    public void run() {
//        nonSleep();
        sleep();
        log.debug("Thread {} exiting.", threadName);
    }

    @Override
    public void start () {
        log.debug("Starting {}", threadName);
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    private void sleep() {
        log.debug("Running {}", threadName);
        try {
            for(int i = 4; i > 0; i--) {
                log.debug("Thread: {} , {}", threadName, i);
                // Let the thread sleep for a while.
//                Thread.sleep(1000);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            log.debug("Thread {} interrupted.", threadName);
        }
    }

    private void nonSleep() {
        log.debug("Running {}", threadName);
        for(int i = 4; i > 0; i--) {
            log.debug("Thread: {} , {}", threadName, i);
        }
    }

}
