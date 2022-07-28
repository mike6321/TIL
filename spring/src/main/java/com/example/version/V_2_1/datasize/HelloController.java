package com.example.version.V_2_1.datasize;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${chickenSize}")
    private DataSize chickenSize;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("chickenSize = " + chickenSize);
        System.out.println("chickenSize.toMegabytes() = " + chickenSize.toMegabytes());
        return "hello";
    }


}
