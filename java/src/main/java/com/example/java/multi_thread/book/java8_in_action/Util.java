package com.example.java.multi_thread.book.java8_in_action;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

public class Util {

    private static final Random RANDOM = new Random(0);
    private static final DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

    public static void delay() {
        int delay = 5000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
