package com.example.java.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayVSList {

    public static void main(String[] args) {
        /**
         * Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer
         * */
//        Object[] objectArray = new String[1]; // 배열은 String 타입이지만, Object 타입으로 참조
//        objectArray[0] = 1; // 런타임 오류: ArrayStoreException

        // 이 코드는 컴파일 시점에는 오류가 발생하지 않습니다.
        // 그러나 런타임에 objectArray[0]에 Integer를 저장하려고 하면
        // ArrayStoreException이 발생합니다.
        // 이는 배열이 런타임에 실제 타입을 체크하기 때문입니다.

        List<String> stringList = new ArrayList<>();
//        stringList.add(1);
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        stringList.add("6");
        stringList.add("7");
        stringList.add("8");
        stringList.add("9");
        stringList.add("10");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");
        stringList.add("11");

    }

}
