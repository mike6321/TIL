package com.example.java.multi_thread.section03;

public class Example06 {

    /**
     * user level thread 가 종료되면 전체 프로세스가 종료된다.
     * 이유는 user level thread 는 demon thread 가 종료됨을 기다리지 않기 때문이다.
     *
     * JVM 은 demon thread 의 종료를 기다리지 않기 때문에 user level thread 가 종료되면 프로세스가 종료된다.
     * 다만 demon thread 에 join 을 선언하면 demon thread 가 종료될 때 까지 프로세스가 종료되지 않는다.
     * 이유는 join 을 선언함으로써 demo thread 는 user level thread 인 것처럼 동작하기 때문이다.
     * */
    public static void main(String[] args) throws InterruptedException {
        Runnable myThread = () -> System.out.println("MyThread");
        Thread thread01 = new Thread(new MyThread(10), "thread-01"); // demon thread
        Thread thread02 = new Thread(new MyThread(3), "thread-02"); // user level thread

        thread01.setDaemon(true);

        thread01.start();
        thread02.start();

        thread01.join();
    }

    static class MyThread implements Runnable {

        private final int numberOfSeconds;

        public MyThread(int numberOfSeconds) {
            this.numberOfSeconds = numberOfSeconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < this.numberOfSeconds; i++) {
                System.out.println("Sleeping for 1s, Thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
