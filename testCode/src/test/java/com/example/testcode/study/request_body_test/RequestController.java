package com.example.testcode.study.request_body_test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @GetMapping("/primitive-test")
//    public ResponseEntity<RequestDto> getTest(@RequestBody RequestDto requestDto) {
    public ResponseEntity<RequestDto> getTest(RequestDto requestDto) {
        ResponseEntity<RequestDto> ok = ResponseEntity.ok(requestDto);
        return ok;
    }

}
