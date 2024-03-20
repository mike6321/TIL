package com.example.spring.performance;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/log")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("test...!");
    }

}
