package com.example.designpattern.singleton.phase07;

import java.io.Serializable;

public class Setting implements Serializable {

    private Setting() {
    }

    private static class LazyHolder {
        private static final Setting INSTANCE = new Setting();
    }

    public static Setting getInstance() {
        return LazyHolder.INSTANCE;
    }

}
