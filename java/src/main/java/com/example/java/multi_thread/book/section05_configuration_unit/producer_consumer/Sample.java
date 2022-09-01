package com.example.java.multi_thread.book.section05_configuration_unit.producer_consumer;

public class Sample {

    public static void main(String[] args) {
        Table table = new Table(3);
        new MakerThread("MakerThread-1", table, 31415).start();
        new MakerThread("MakerThread-2", table, 92653).start();
        new MakerThread("MakerThread-3", table, 58979).start();
        new EnterThread("EnterThread-1", table, 32384).start();
        new EnterThread("EnterThread-2", table, 62643).start();
        new EnterThread("EnterThread-3", table, 38327).start();
    }

}
