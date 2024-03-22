package com.example.spring.performance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @GetMapping("/log")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("test...!");
    }

    @GetMapping("/cpu")
    public String cpu() {
        log.info("cpu");
        long var = 0;
        for (int i = 0; i < 10000000000l; i++) {
            var++;
        }

        return "ok value = " + var;
    }

}
