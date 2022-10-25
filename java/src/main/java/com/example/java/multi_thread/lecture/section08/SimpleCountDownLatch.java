package com.example.java.multi_thread.lecture.section08;

public class SimpleCountDownLatch {

    private int count;

    public SimpleCountDownLatch(int count) {
        this.count = count;
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be negative");
        }
    }
    
    public synchronized void await() throws InterruptedException {
        synchronized (this) {
            if (count != 0) {
                wait();
            }
        }
    }

    public synchronized void countDown() {
        synchronized (this) {
            if (count > 0) {
                count--;
                if (count == 0) {
                    notifyAll();
                }
            }
        }
    }

    public int getCount() {
        return this.count;
    }

}
