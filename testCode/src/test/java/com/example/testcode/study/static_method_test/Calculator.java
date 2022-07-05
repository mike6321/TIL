package com.example.testcode.study.static_method_test;

public class Calculator {

    public double calculate(double num1, double num2) {
        double calculate = CalculateService.calculate(num1, num2);
        return calculate;
    }

}
