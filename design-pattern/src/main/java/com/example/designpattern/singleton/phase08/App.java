package com.example.designpattern.singleton.phase08;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * enum 으로 시용하면 리플렉션으로 뚫을 수 가 없다.
 * */
public class App {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Setting instance1 = Setting.INSTANCE;
        Setting instance2 = null;
        Constructor<?>[] declaredConstructors = Setting.class.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            instance2 = (Setting) declaredConstructor.newInstance("INSTANCE");
        }

        System.out.println(instance1 == instance2

        );
    }

}
