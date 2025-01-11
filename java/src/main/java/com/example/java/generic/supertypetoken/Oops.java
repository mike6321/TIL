package com.example.java.generic.supertypetoken;

import java.util.List;

public class Oops {

    static Favorite2 favorite2 = new Favorite2();

    static <T> List<T> favoriteList() {
        TypeRef<List<T>> typeRef = new TypeRef<>() {};
        System.out.println(typeRef.getType());
        
        List<T> list = favorite2.get(typeRef);

        if (list == null) {
            list = List.of();
            favorite2.put(typeRef, list);
        }

        return list;
    }

    public static void main(String[] args) {
        List<String> ls = favoriteList();
        List<Integer> li = favoriteList();

        li.add(1);

        for (Integer i : li) {
            System.out.println(i);
        }
    }

}
