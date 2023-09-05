package com.example.java.effectivejava.item21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFast {

    public static void main(String[] args) {
        // Immutable - UnsupportedOperationException
//        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
//        for (Integer n : numbers1) {
//            if (n == 3) {
//                numbers1.remove(3);
//            }
//        }

        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(1);
        numbers2.add(2);
        numbers2.add(3);
        numbers2.add(4);
        numbers2.add(5);
        // 순회하는 도중 remove - ConcurrentModificationException (SingleThread 환경에서도 발생)
        // 순회와 제거를 동시에 하였기 떄문
        for (Integer n : numbers2) {
            if (n == 3) {
                numbers2.remove(3);
            }
        }

        for (Iterator<Integer> iterator = numbers2.iterator(); iterator.hasNext();) {
            Integer next = iterator.next();
            if (next == 3) {
                iterator.remove();
            }
        }

        numbers2.removeIf(n -> n == 3);
        numbers2.forEach(System.out::println);
    }

}
