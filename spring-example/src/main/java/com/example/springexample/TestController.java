package com.example.springexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final RequestContext requestContext;

    public TestController(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @GetMapping("/test")
    public void test() {
        System.out.println(requestContext.getUserId());
    }
}
