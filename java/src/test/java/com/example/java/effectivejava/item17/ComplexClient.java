package com.example.java.effectivejava.item17;

public class ComplexClient {

    public static void main(String[] args) {
        Complex complex = Complex.valueOf(1.0, 2.0);
        double im = complex.getIm();
        System.out.println(im);
    }

}
