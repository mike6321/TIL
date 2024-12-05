package com.example.designpattern.singletonpattern.phase01;

public class Setting {

    private static Setting instance;

    private Setting() {
    }

    public static Setting getInstance() {
        if (instance == null) {
            instance = new Setting();
        }
        return instance;
    }

}
