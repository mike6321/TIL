package com.example.testcode.study.restdoc.production;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestDocTestController {

    private final RestDocTestService restDocTestService;

    @GetMapping("/test/{testId}")
    public ResponseEntity<TestRequestDto> getTest(@PathVariable(name = "testId") Long testId,
                                                  @RequestBody TestRequestDto testRequestDto) {
        TestRequestDto responseDto = restDocTestService.getMethod(testRequestDto);
        return ResponseEntity.ok(responseDto);
    }

}
