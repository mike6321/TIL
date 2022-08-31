package com.example.java.multi_thread.book.section05_configuration_unit.producer_consumer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Table {

    private final String[] buffer;
    private int tail; // 다음에 put 할 장소
    private int head; // 다음에 take 할 장소
    private int count; // buffer 안의 케이크 수

    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = count;
    }

    public synchronized void put(String cake) throws InterruptedException {
        log.info("{} puts {}", Thread.currentThread().getName(), cake);
        while (count >= buffer.length) {
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        log.info("{} take {}", Thread.currentThread().getName(), cake);
        return cake;
    }

}
