package com.example.java.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * -verbose:gc
 * [Full GC (Ergonomics)  161581K->145107K(413184K), 0.9116102 secs]
 * */
public class GCProfiling {

    public static void main(String[] args) throws InterruptedException {
        List<String> buffer = new ArrayList<>();
        for (int i = 0; true; i++) {
            if (i > 0 && i % 100000 == 0) {
                System.out.println(green("Current Buffer.size() = " + buffer.size()));
                Thread.sleep(1000);
            }
            buffer.add(new String("ABCDERGHIJKLNMOPQRSTUVWXYZ"));
        }
    }

    private static String green(String str) {
        return "\u001B[32m" + str + "\u001B[0m";
    }
}
