package com.example.java.effectivejava.item21;

public interface MarkerInterface {

    default void hello(){
        System.out.println("hello interface");
    }

}
