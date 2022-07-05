package com.example.testcode.study.static_method_test;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mockStatic;

public class CalculateTest {

    @Test
    void calculateTest() {
        MockedStatic<CalculateService> mockStatic = mockStatic(CalculateService.class);
        given(CalculateService.calculate(any(Double.class), any(Double.class))).willReturn(1.0);
        Calculator calculator = new Calculator();
        double calculate = calculator.calculate(Double.valueOf(1), Double.valueOf(2));
        System.out.println(calculate);
        mockStatic.close();
    }

}
