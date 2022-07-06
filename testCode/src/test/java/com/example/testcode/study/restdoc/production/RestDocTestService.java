package com.example.testcode.study.restdoc.production;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RestDocTestService {

    private static final String TEST_MESSAGE = "TestService.getMethod";

    public TestRequestDto getMethod(TestRequestDto testRequestDto) {
        log.info(TEST_MESSAGE);
        return testRequestDto;
    }

}
