package com.example.java.generic.supertypetoken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Favorite2 {

    private final Map<TypeRef<?>, Object> map = new HashMap<>();

    public <T> void put(TypeRef<T> typeRef, T object) {
        map.put(Objects.requireNonNull(typeRef), object);
    }

    public <T> T get(TypeRef<T> typeRef) {
        return (T) map.get(typeRef);
    }

    public static void main(String[] args) {
        Favorite2 favorite = new Favorite2();
        favorite.put(new TypeRef<>() {
        }, "Java");
        favorite.put(new TypeRef<>() {
        }, 1);
        favorite.put(new TypeRef<>() {
        }, List.of("Java", "Kotlin"));
        favorite.put(new TypeRef<>() {
        }, List.of(1, 2, 3));


        String resultString = favorite.get(new TypeRef<>() {
        });
        System.out.println("resultString = " + resultString);
        Integer resultInteger = favorite.get(new TypeRef<>() {
        });
        System.out.println("resultInteger = " + resultInteger);
        List<String> resultListString = favorite.get(new TypeRef<>() {
        });
        for (String s : resultListString) {
            System.out.println(s);
        }
        List<Integer> resultListInteger = favorite.get(new TypeRef<>() {
        });
        for (Integer i : resultListInteger) {
            System.out.println(i);
        }
    }

}
