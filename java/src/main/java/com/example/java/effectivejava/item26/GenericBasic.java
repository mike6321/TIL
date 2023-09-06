package com.example.java.effectivejava.item26;

import java.util.ArrayList;
import java.util.List;

public class GenericBasic {

    public static void main(String[] args) {

        // before generic
        List numbers = new ArrayList();
        numbers.add(10);
        numbers.add("jwdeveloper");

        // compile time 에 error x
//        for (Object number : numbers) {
//            System.out.println((Integer) number);
//        }


        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(10);
//        numbers2.add("jwdeveloper");

    }

}
