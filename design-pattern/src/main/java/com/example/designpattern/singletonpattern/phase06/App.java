package com.example.designpattern.singletonpattern.phase06;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Setting> declaredConstructor = Setting.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        Setting setting1 = declaredConstructor.newInstance();
        Setting setting2 = Setting.getInstance();

        System.out.println(setting1 == setting2);
    }

}
