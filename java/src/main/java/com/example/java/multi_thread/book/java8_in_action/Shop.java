package com.example.java.multi_thread.book.java8_in_action;

import java.util.Random;

import static com.example.java.multi_thread.book.java8_in_action.Util.delay;

public class Shop {

    private final String name;
    private final Random random;

    public static void main(String[] args) {
        Shop shop = new Shop("junwoo-shop");
        double product = shop.getPrice("product");
        System.out.println(product);
    }

    public Shop(String name) {
        this.name = name;
        this.random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) * product.charAt(1);
    }

}
