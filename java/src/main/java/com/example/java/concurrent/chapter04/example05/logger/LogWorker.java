package com.example.java.concurrent.chapter04.example05.logger;

public class LogWorker implements Runnable {

    @Override
    public void run() {
        ThreadLocalLogger.ServiceA serviceA = new ThreadLocalLogger.ServiceA();
        ThreadLocalLogger.ServiceB serviceB = new ThreadLocalLogger.ServiceB();
        ThreadLocalLogger.ServiceC serviceC = new ThreadLocalLogger.ServiceC();

        if (Thread.currentThread().getName().contains("THREAD-1")) {
            serviceA.process();
            serviceB.process();
            serviceC.process();
        } else if (Thread.currentThread().getName().contains("THREAD-2")) {
            serviceB.process();
            serviceA.process();
            serviceC.process();
        } else if (Thread.currentThread().getName().contains("THREAD-3")) {
            serviceC.process();
            serviceA.process();
            serviceB.process();
        }

        ThreadLocalLogger.printLogs();
        ThreadLocalLogger.clearLogs();
    }

}
