package com.example.designpattern.singletonpattern.phase03;

public class Setting {

    private static final Setting INSTANCE = new Setting();

    private Setting() {
    }

    public static Setting getInstance() {
        return INSTANCE;
    }

}
