package com.example.version.V_2_1.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_hello() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/hello"));
        /**
         * Lamda 를 사용해전체 실행 가능
         * */
        Assertions.assertAll(
                () -> resultActions.andExpect(status().isBadRequest()),
                () -> resultActions.andExpect(content().string("hello!"))
        );
    }

}
