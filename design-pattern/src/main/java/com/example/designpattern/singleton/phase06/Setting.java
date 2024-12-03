package com.example.designpattern.singleton.phase06;

public class Setting {

    private Setting() {
    }

    private static class LazyHolder {
        private static final Setting INSTANCE = new Setting();
    }

    public static Setting getInstance() {
        return LazyHolder.INSTANCE;
    }

}
