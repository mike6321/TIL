package com.example.java.effectivejava.item17;

public class JMMFinalFieldExample {

    private final int x;
    private int y;
    static JMMFinalFieldExample f;

    public JMMFinalFieldExample() {
        this.x = 1;
        this.y = 2;
    }

    static void writer() {
        f = new JMMFinalFieldExample();
    }

    static void reader() {
        if (f != null) {
            int i = f.x; // guaranteed to see 3
            int j = f.y; // could see 0
        }
    }

}
