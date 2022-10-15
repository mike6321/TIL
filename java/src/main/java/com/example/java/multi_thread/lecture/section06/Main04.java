package com.example.java.multi_thread.lecture.section06;

public class Main04 {

    public static void main(String[] args) {
        SharedClass sharedClass = new SharedClass();
        // TODO: 2022/10/15 Stream을 사용하였을때 Data Race가 발생하지 않는다.
//        Thread thread01 = new Thread(() -> IntStream.range(0, Integer.MAX_VALUE)
//                .forEach(index -> sharedClass.increment()));
//        Thread thread02 = new Thread(() -> IntStream.range(0, Integer.MAX_VALUE)
//                .forEach(index -> sharedClass.checkForDataRace()));

        Thread thread01 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedClass.increment();
            }
        });
        Thread thread02 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedClass.checkForDataRace();
            }
        });

        thread01.start();
        thread02.start();
    }

    public static class SharedClass {
        private volatile int x = 0;
        private volatile int y = 0;

        public void increment() {
            x++;
            y++;
        }

        public void checkForDataRace() {
            if (y > x) {
                System.out.println("y > x - Data Race is detected");
            }
        }

    }

}
