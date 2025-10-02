package com.example.stream;

import java.util.*;
import java.util.function.*;

public class LambdaAndMethodReference {
    
    public static void main(String[] args) {
        System.out.println("=== 람다식과 메서드 참조 비교 ===\n");
        
        List<String> names = Arrays.asList("김철수", "이영희", "박민수", "최영수", "정미영");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // 1. 람다식 vs 메서드 참조 비교
        System.out.println("1. 람다식 vs 메서드 참조");
        
        // 람다식으로 출력
        System.out.println("람다식 사용:");
        names.stream()
            .forEach(name -> System.out.println(name));
        
        // 메서드 참조로 출력
        System.out.println("\n메서드 참조 사용:");
        names.stream()
            .forEach(System.out::println);
        
        // 2. 다양한 메서드 참조 패턴
        System.out.println("\n2. 다양한 메서드 참조 패턴");
        
        // 정적 메서드 참조 (Static Method Reference)
        Function<Double, Long> roundLambda = d -> Math.round(d);
        Function<Double, Long> roundMethodRef = Math::round;
        
        System.out.println("정적 메서드 참조 - Math.round(3.7): " + roundMethodRef.apply(3.7));
        
        // 인스턴스 메서드 참조 (Instance Method Reference)
        String testString = "Hello World";
        Supplier<String> upperLambda = () -> testString.toUpperCase();
        Supplier<String> upperMethodRef = testString::toUpperCase;
        
        System.out.println("인스턴스 메서드 참조: " + upperMethodRef.get());
        
        // 특정 타입의 임의 객체의 인스턴스 메서드 참조
        Function<String, Integer> lengthLambda = str -> str.length();
        Function<String, Integer> lengthMethodRef = String::length;
        
        System.out.println("타입의 인스턴스 메서드 참조 - 'Hello'.length(): " + lengthMethodRef.apply("Hello"));
        
        // 생성자 참조 (Constructor Reference)
        Supplier<List<String>> listLambda = () -> new ArrayList<>();
        Supplier<List<String>> listMethodRef = ArrayList::new;
        
        Function<Integer, List<String>> listWithSizeLambda = size -> new ArrayList<>(size);
        Function<Integer, List<String>> listWithSizeMethodRef = ArrayList::new;
        
        System.out.println("생성자 참조로 리스트 생성: " + listMethodRef.get());
        
        // 3. 실제 활용 예제
        System.out.println("\n3. 실제 활용 예제");
        
        // 문자열 길이로 정렬 (람다식)
        System.out.println("람다식으로 길이 정렬:");
        names.stream()
            .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
            .forEach(System.out::println);
        
        // 문자열 길이로 정렬 (메서드 참조)
        System.out.println("\n메서드 참조로 길이 정렬:");
        names.stream()
            .sorted(Comparator.comparing(String::length))
            .forEach(System.out::println);
        
        // 숫자 필터링과 변환
        System.out.println("\n숫자 처리 예제:");
        numbers.stream()
            .filter(n -> n % 2 == 0)  // 짝수만
            .map(n -> n * n)          // 제곱
            .forEach(System.out::println);
        
        // 4. 복합 함수 예제
        System.out.println("\n4. 복합 함수 예제");
        
        // 문자열 처리 파이프라인
        Function<String, String> addPrefix = str -> "안녕 " + str;
        Function<String, String> addSuffix = str -> str + "님!";
        Function<String, String> processName = addPrefix.andThen(addSuffix);
        
        names.stream()
            .map(processName)
            .forEach(System.out::println);
        
        // 5. 커스텀 함수형 인터페이스와 메서드 참조
        System.out.println("\n5. 커스텀 함수형 인터페이스");
        
        Calculator calculator = new Calculator();
        
        // 메서드 참조로 사용
        BinaryOperator<Integer> addOperation = calculator::add;
        BinaryOperator<Integer> multiplyOperation = calculator::multiply;
        
        System.out.println("덧셈 (5 + 3): " + addOperation.apply(5, 3));
        System.out.println("곱셈 (5 * 3): " + multiplyOperation.apply(5, 3));
        
        // 정적 메서드 참조
        BinaryOperator<Integer> maxOperation = Calculator::max;
        System.out.println("최댓값 (5, 3): " + maxOperation.apply(5, 3));
    }
    
    static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
        
        public int multiply(int a, int b) {
            return a * b;
        }
        
        public static int max(int a, int b) {
            return Math.max(a, b);
        }
    }
}