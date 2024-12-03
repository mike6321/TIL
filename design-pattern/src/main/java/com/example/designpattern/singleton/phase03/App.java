package com.example.designpattern.singleton.phase03;

public class App {

    public static void main(String[] args) {
        Setting setting1 = Setting.getInstance();
        Setting setting2 = Setting.getInstance();
        System.out.println(setting1 == setting2);
    }

}
