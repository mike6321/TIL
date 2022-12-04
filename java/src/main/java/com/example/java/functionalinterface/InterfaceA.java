package com.example.java.functionalinterface;

@FunctionalInterface
public interface InterfaceA {

    Mono filter(String exchange, String chain);

}
