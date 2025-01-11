package com.example.java.generic.typetoken.step01;

import java.util.HashMap;
import java.util.Map;

public class Favorite {

    private final Map<Class, Object> map = new HashMap<>();

    public void put(Class clazz, Object object) {
        map.put(clazz, object);
    }

    public Object get(Class clazz) {
        return map.get(clazz);
    }

    public static void main(String[] args) {
        Favorite favorite = new Favorite();
        favorite.put(String.class, "Java");
        favorite.put(Integer.class, 1);
        favorite.put(Integer.class, "Java"); // ?
        favorite.put(Integer.class, 1);

        System.out.println(favorite.get(String.class));
        System.out.println(favorite.get(Integer.class));
    }

}
