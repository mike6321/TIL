package com.example.java.collections;

public class CacheEfficiencyTest {
    public static void main(String[] args) {
        final int size = 10000000; // 큰 배열 크기
        int[] array = new int[size];

        // 배열 초기화
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        // 순차적 접근
        long startTime = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i];
        }
        long endTime = System.nanoTime();
        System.out.println("순차적 접근 시간: " + (endTime - startTime) + " 나노초");

        // 무작위 접근
        startTime = System.nanoTime();
        sum = 0;
        for (int i = 0; i < size; i++) {
            int index = (int)(Math.random() * size);
            sum += array[index];
        }
        endTime = System.nanoTime();
        System.out.println("무작위 접근 시간: " + (endTime - startTime) + " 나노초");
    }
}

