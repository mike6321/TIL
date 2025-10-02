package com.example.stream;

import java.util.function.*;
import java.util.List;
import java.util.Arrays;

public class FunctionalInterfaceAdvanced {
    
    public static void main(String[] args) {
        System.out.println("=== Functional Interface 고급 사용법 ===\n");
        
        // Function 체이닝
        Function<String, String> addPrefix = str -> "접두어_" + str;
        Function<String, String> addSuffix = str -> str + "_접미어";
        Function<String, String> toUpper = String::toUpperCase;
        
        Function<String, String> chainedFunction = addPrefix
            .andThen(addSuffix)
            .andThen(toUpper);
        
        System.out.println("Function 체이닝: " + chainedFunction.apply("테스트"));
        
        // Predicate 조합
        Predicate<Integer> isPositive = num -> num > 0;
        Predicate<Integer> isLessThan100 = num -> num < 100;
        Predicate<Integer> isEven = num -> num % 2 == 0;
        
        Predicate<Integer> isValidEvenNumber = isPositive
            .and(isLessThan100)
            .and(isEven);
        
        System.out.println("Predicate 조합 - 50은 유효한 짝수? " + isValidEvenNumber.test(50));
        System.out.println("Predicate 조합 - 101은 유효한 짝수? " + isValidEvenNumber.test(101));
        System.out.println("Predicate 조합 - 51은 유효한 짝수? " + isValidEvenNumber.test(51));
        
        // Consumer 체이닝
        Consumer<String> printWithBrackets = str -> System.out.print("[" + str + "]");
        Consumer<String> printNewLine = str -> System.out.println();
        Consumer<String> printUpperCase = str -> System.out.print(" " + str.toUpperCase() + " ");
        
        Consumer<String> chainedConsumer = printWithBrackets
            .andThen(printUpperCase)
            .andThen(printNewLine);
        
        System.out.print("Consumer 체이닝: ");
        chainedConsumer.accept("hello");
        
        // 커스텀 Functional Interface 예제
        TriFunction<Integer, Integer, Integer, Integer> addThree = (a, b, c) -> a + b + c;
        System.out.println("커스텀 함수형 인터페이스 - 세 수의 합: " + addThree.apply(1, 2, 3));
        
        // 실제 활용 예제 - 리스트 처리
        List<String> names = Arrays.asList("김철수", "이영희", "박민수", "최영수", "정미영");
        
        System.out.println("\n=== 리스트 처리 예제 ===");
        
        // 길이가 3글자인 이름 필터링
        Predicate<String> isThreeChar = name -> name.length() == 3;
        names.stream()
            .filter(isThreeChar)
            .forEach(name -> System.out.println("3글자 이름: " + name));
        
        // 이름을 대문자로 변환
        Function<String, String> nameToUpper = String::toUpperCase;
        System.out.println("\n대문자 변환:");
        names.stream()
            .map(nameToUpper)
            .forEach(System.out::println);
        
        // 이름에 '영'이 포함된 사람 찾기
        Predicate<String> containsYoung = name -> name.contains("영");
        System.out.println("\n'영'이 포함된 이름:");
        names.stream()
            .filter(containsYoung)
            .forEach(System.out::println);
    }
    
    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}