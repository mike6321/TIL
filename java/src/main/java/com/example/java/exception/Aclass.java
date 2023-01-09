package com.example.java.exception;

public class Aclass {

    public static void main(String[] args) {
        Bclass bclass = new Bclass();
        try {
            bclass.method();
        } catch (RuntimeException e) {
            System.out.println("!!!");
        }
    }

}
