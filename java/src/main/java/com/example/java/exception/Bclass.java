package com.example.java.exception;

public class Bclass {

    public void method() {
        try {
            error();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public void error() {
        throw new RuntimeException();
    }

}
