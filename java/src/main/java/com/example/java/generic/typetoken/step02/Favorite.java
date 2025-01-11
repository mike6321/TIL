package com.example.java.generic.typetoken.step02;

import java.util.HashMap;
import java.util.Map;

public class Favorite {

    private final Map<Class<?>, Object> map = new HashMap<>();

    public <T> void put(Class<T> clazz, T object) {
        map.put(clazz, object);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> clazz) {
        return (T) map.get(clazz);
    }

    public static void main(String[] args) {
        Favorite favorite = new Favorite();
        favorite.put(String.class, "Java");
        favorite.put(Integer.class, 1);
        // java: method put in class com.example.java.typetoken.step02.Favorite cannot be applied to given types;
        // favorite.put(Integer.class, "Java");

        System.out.println(favorite.get(String.class));
        System.out.println(favorite.get(Integer.class));

        Integer result = favorite.get(Integer.class);
    }

}
