package com.example.testcode.study.standalone_test.production;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("/test")
    public ResponseEntity<TestRequestDto> getTest(@RequestBody TestRequestDto testRequestDto) {
        TestRequestDto responseDto = testService.getMethod(testRequestDto);
        return ResponseEntity.ok(responseDto);
    }

}
