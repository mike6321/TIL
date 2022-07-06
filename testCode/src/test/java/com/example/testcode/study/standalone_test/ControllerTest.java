package com.example.testcode.study.standalone_test;

import com.example.testcode.study.standalone_test.production.TestController;
import com.example.testcode.study.standalone_test.production.TestRequestDto;
import com.example.testcode.study.standalone_test.production.TestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(value = MockitoExtension.class)
@ActiveProfiles("test")
public class ControllerTest {

    private static final String PATH = "/test";

    @InjectMocks
    private TestController testController;
    @Mock
    private TestService testService;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        setUpMockMvcStandAlone();
        setUpObjectMapper();
    }

    private void setUpObjectMapper() {
        objectMapper= new ObjectMapper().registerModule(new JavaTimeModule());
    }

    private void setUpMockMvcStandAlone() {
        mockMvc = MockMvcBuilders.standaloneSetup(testController)
                .build();
    }

    @Test
    public void controller_test() throws Exception {
        // given
        TestRequestDto testRequestDto = new TestRequestDto(1L, "name");
        String requestBody = objectMapper.writeValueAsString(testRequestDto);
        String responseBody = objectMapper.writeValueAsString(testRequestDto);
        given(testService.getMethod(any(TestRequestDto.class))).willReturn(testRequestDto);
        // when
        ResultActions perform = mockMvc.perform(get(PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));
        // then
        perform.andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(responseBody));
    }


}
