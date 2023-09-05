package com.example.java.effectivejava.item17;

// effectively final
public class Complex {

    private final double re;
    private final double im;

    // 상속을 강제
    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    private static class MyComplex extends Complex {

        private MyComplex(double re, double im) {
            super(re, im);
        }

    }

    public static Complex valueOf(double re, double im) {
        // instance 를 갈아 끼울 수도 있다.
//        return new Complex(re, im);
        return new MyComplex(re, im);
    }

    public double getIm() {
        return im;
    }

}
