package com.example.java.gc;

public class YoungGCDemo {

    private static final int SIZE = 1000000000;

    // 이 메소드는 많은 양의 객체를 생성하여 메모리를 채웁니다.
    private static void createObjects() throws InterruptedException {
        for (int i = 0; i < SIZE; i++) {
            Object object = new Object();
            Thread.sleep(100);
            System.out.println(111);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // GC 로그를 활성화하려면 JVM 옵션에 -verbose:gc 추가
        System.out.println("Starting to create objects");
        createObjects();
        System.out.println("Finished creating objects");

        // GC를 유도하고 싶은 경우 아래 코드를 사용
        // System.gc();
    }

}
