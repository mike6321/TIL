package com.example.designpattern.singleton.phase02;

public class Setting {

    private static Setting instance;

    private Setting() {
    }

    public synchronized static Setting getInstance() {
        if (instance == null) {
            instance = new Setting();
        }
        return instance;
    }

}
