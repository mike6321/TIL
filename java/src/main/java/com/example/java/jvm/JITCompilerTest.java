package com.example.java.jvm;

import java.util.stream.IntStream;

/**
 * -XX:+UnlockDiagnosticVMOptions-XX:+LogCompilation
 * */
public class JITCompilerTest {

    public static void main(String[] args) {
        var jitCompilerTest = new JITCompilerTest();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int N = 1;
        IntStream.rangeClosed(1, N).forEach(i -> {
            try {
                jitCompilerTest.findMax(arr);
                if (i % 100 == 0) {
                    Thread.sleep(100);
                }
            } catch (Exception e) {

            }
        });
    }

    private int findMax(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

}
