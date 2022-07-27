package com.example.testcode.study.argument_capture_test.production;

import com.example.testcode.study.standalone_test.production.TestRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public String method(String var) {
        return testRepository.save(var);
    }

}
