package com.example.stream;

import java.util.function.*;

public class FunctionalInterfaceBasics {
    
    public static void main(String[] args) {
        System.out.println("=== Functional Interface 기본 개념 ===\n");
        
        // 1. Function<T, R>: T를 받아서 R을 반환
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println("Function - '자바'의 길이: " + stringLength.apply("자바"));
        
        Function<Integer, String> intToString = num -> "숫자: " + num;
        System.out.println("Function - 숫자를 문자열로: " + intToString.apply(42));
        
        // 2. Predicate<T>: T를 받아서 boolean 반환
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Predicate - 10은 짝수? " + isEven.test(10));
        System.out.println("Predicate - 15는 짝수? " + isEven.test(15));
        
        Predicate<String> isLongString = str -> str.length() > 5;
        System.out.println("Predicate - '안녕하세요'는 5글자 초과? " + isLongString.test("안녕하세요"));
        
        // 3. Consumer<T>: T를 받아서 처리하고 반환값 없음
        Consumer<String> printer = msg -> System.out.println("Consumer 출력: " + msg);
        printer.accept("안녕하세요!");
        
        Consumer<Integer> numberProcessor = num -> {
            System.out.println("Consumer - 처리중인 숫자: " + num);
            System.out.println("Consumer - 제곱값: " + (num * num));
        };
        numberProcessor.accept(5);
        
        // 4. Supplier<T>: 파라미터 없이 T를 반환
        Supplier<String> randomGreeting = () -> {
            String[] greetings = {"안녕하세요", "반갑습니다", "좋은 하루입니다"};
            return greetings[(int) (Math.random() * greetings.length)];
        };
        System.out.println("Supplier - 랜덤 인사: " + randomGreeting.get());
        
        Supplier<Integer> randomNumber = () -> (int) (Math.random() * 100);
        System.out.println("Supplier - 랜덤 숫자: " + randomNumber.get());
        
        // 5. BinaryOperator<T>: 같은 타입 두 개를 받아서 같은 타입 반환
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println("BinaryOperator - 3 + 7 = " + sum.apply(3, 7));
        
        BinaryOperator<String> concat = (s1, s2) -> s1 + " " + s2;
        System.out.println("BinaryOperator - 문자열 합치기: " + concat.apply("자바", "스터디"));
        
        // 6. UnaryOperator<T>: T를 받아서 T를 반환
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println("UnaryOperator - 4의 제곱: " + square.apply(4));
        
        UnaryOperator<String> upperCase = String::toUpperCase;
        System.out.println("UnaryOperator - 대문자 변환: " + upperCase.apply("hello"));
    }
}