package com.example.java.concurrent.chapter03.example01;

public class d_InterruptSleepExample {

    public static void main(String[] args) throws InterruptedException {
        Thread sleepingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Sleeping for 20 seconds (인터럽트되지 않는다면 계속 Sleep 상태에 있을 것입니다.)");
                    Thread.sleep(20000);
                    System.out.println("인터럽트 없이 Sleep 이 끝났습니다.");
                } catch (InterruptedException e) {
                    System.out.println("인터럽트로 Sleep 이 끝났습니다.");
                }
            }
        });
        sleepingThread.start();

        Thread.sleep(1000);
        sleepingThread.interrupt();
    }

}
