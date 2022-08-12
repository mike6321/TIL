package com.example.java.multi_thread.book.section03_object_sharing;

import lombok.extern.slf4j.Slf4j;

/**
 * 재배치 현상 발생 가능성
 *  -> 무한루프
 * It might be delayed write
 * (due to any reasons, including how low level OS mechanism handles threads)
 * to main memory which makes the code appears to be reordered or might be because of real code ordering as a results of JIT compiler/processor code optimization.
 * */
@Slf4j
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            // ready 가 true 가 되었을 때 Thread 종료
            while (!ready) {
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReaderThread readerThread = new ReaderThread();
        readerThread.start();
        number = 42;
        ready = true;
    }

}
