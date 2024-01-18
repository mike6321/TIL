package com.example.java.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapEquality {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(1);
        list2.add(2);
        list2.add(3);

        // 두 리스트의 동등성 비교
        System.out.println("ArrayList 동등성: " + list1.equals(list2));

        Map<Integer, String> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");

        map2.put(3, "C");
        map2.put(1, "A");
        map2.put(2, "B");

        // 두 맵의 동등성 비교
        System.out.println("HashMap 동등성: " + map1.equals(map2));
    }
}
