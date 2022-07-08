package com.example.testcode.study.request_body_test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/request-body")
public class RequestController {

    @GetMapping("/unused")
    public ResponseEntity<RequestDto> nonUseRequestBodyTest(RequestDto requestDto) {
        return ResponseEntity.ok(requestDto);
    }

    @GetMapping("/used")
    public ResponseEntity<RequestDto> useRequestBodyTest(@RequestBody RequestDto requestDto) {
        return ResponseEntity.ok(requestDto);
    }

}
