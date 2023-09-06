package com.example.java.effectivejava.item26;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Numbers {

    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        // raw 타입으로 사용하면 타입 안정성이 깨지므로 비한정성 와일드카드 사용
//        s1.add(1);
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        Set mySet = set;
        mySet.add(10);

        System.out.println(Numbers.numElementsInCommon(Set.of(1, 2, 3), Set.of(1, 2)));
    }

}
