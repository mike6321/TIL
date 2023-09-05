package com.example.java.effectivejava.item21;

public class SubClass extends SuperClass implements MarkerInterface {

    public static void main(String[] args) {
        // default method 로 인해 컴파일 에러가 발생하지 않고 런타임 에러 발생
        SubClass subClass = new SubClass();
        subClass.hello();
    }

}
