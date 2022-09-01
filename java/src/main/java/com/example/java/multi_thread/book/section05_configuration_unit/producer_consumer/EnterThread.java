package com.example.java.multi_thread.book.section05_configuration_unit.producer_consumer;

import java.util.Random;

public class EnterThread extends Thread {

    private final Random random;
    private final Table table;

    public EnterThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String cake = table.take();
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {

        }
    }

}
