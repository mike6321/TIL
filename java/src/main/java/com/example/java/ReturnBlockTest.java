package com.example.java;

public class ReturnBlockTest {

    public static void main(String[] args) {
        boolean tag = true;
        method(tag);
    }

    public static void method(boolean tag) {
        if (tag) {
            System.out.println("!");
            return;
        }
        System.out.println("@");
    }

}
