package com.example.java.functionalinterface;

public class Main {

    public static void main(String[] args) {
        InterfaceA interfaceA = (exchange, chain) -> {
            return new Mono(exchange, chain);
        };
    }

}
