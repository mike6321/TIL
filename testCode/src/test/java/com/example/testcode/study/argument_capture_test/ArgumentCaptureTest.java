package com.example.testcode.study.argument_capture_test;

import com.example.testcode.study.argument_capture_test.production.TestRepository;
import com.example.testcode.study.argument_capture_test.production.TestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(value = MockitoExtension.class)
@ActiveProfiles("test")
public class ArgumentCaptureTest {

    @InjectMocks
    private TestService testService;
    @Mock
    private TestRepository testRepository;
    @Captor
    ArgumentCaptor<String> stringCaptor;

    @Test
    void test() {
        String var = "junwoo";
        testService.method(var);
        verify(testRepository, times(1)).save(stringCaptor.capture());
        String value = stringCaptor.getValue();
        Assertions.assertEquals(value, var);
    }

}
