package com.example.testcode.junit_in_action.step01;

/**
 * 1. 단위 테스트는 다른 모든 단위 테스트들과 독립적으로 실행되어야 한다.
 * 2. 프레임워크는 테스트 각각의 오류를 식별하고 보고해야 한다.
 * 3. 어떤 테스트를 실행할지 선택하기가 쉬워야 한다.
 * */
public class CalculatorTest {
    private int nbErrors = 0;

    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 50);
        if (result != 60) {
            throw new IllegalStateException("Bad Result : " + result);
        }
    }

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        try {
            test.testAdd();
        } catch (Throwable e) {
            test.nbErrors++;
            e.printStackTrace();
        }

        if (test.nbErrors > 0) {
            throw new IllegalStateException("There are " + test.nbErrors + "error(s)");
        }
    }

}
