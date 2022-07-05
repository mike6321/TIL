package com.example.testcode.junit_in_action.step03;

import com.example.testcode.junit_in_action.step03.production.DefaultController;
import org.junit.Before;
import org.junit.Test;

public class TestDefaultController {

    private DefaultController controller;

    @Before
    public void instantiate() {
        controller = new DefaultController();
    }

    @Test
    public void testMethod() {
        throw new RuntimeException("implement me");
    }

}
