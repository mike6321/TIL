package com.example.testcode.study.request_body_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(value = MockitoExtension.class)
@ActiveProfiles("test")
public class RequestControllerUnitTest {

    private static final String PATH = "/request-body";
    private MockMvc mockUseInitBinderMvc;
    private MockMvc mockNonUseInitBinderMvc;
    private ObjectMapper objectMapper;
    @InjectMocks
    private RequestController requestController;

    @BeforeEach
    void setUp() {
        setUpMockUseInitBinderMvc();
        setUpMockNonUseInitBinderMvc();
        setUpObjectMapper();
    }

    private void setUpObjectMapper() {
        objectMapper= new ObjectMapper().registerModule(new JavaTimeModule());
    }

    private void setUpMockUseInitBinderMvc() {
        mockUseInitBinderMvc = MockMvcBuilders.standaloneSetup(requestController)
                .setControllerAdvice(WebControllerAdvice.class)
                .build();
    }

    private void setUpMockNonUseInitBinderMvc() {
        mockNonUseInitBinderMvc = MockMvcBuilders.standaloneSetup(requestController)
                .build();
    }

    @Test
    @DisplayName("@RequestBody O - InitBinder 사용한 QueryString Param Test")
    public void controller_content_test() throws Exception {
        RequestDto requestDto = new RequestDto("junwoo", 1, 2);
        String requestBody = objectMapper.writeValueAsString(requestDto);
        String responseBody = objectMapper.writeValueAsString(requestDto);
        ResultActions perform = mockNonUseInitBinderMvc.perform(get(PATH + "/used")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));

        perform.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(responseBody))
                .andDo(print());
    }

    @Test
    @DisplayName("@RequestBody X - InitBinder 사용한 QueryString Param Test")
    public void controller_use_init_binder_params_test() throws Exception {
        RequestDto requestDto = new RequestDto("junwoo", 1, 2);
        String responseBody = objectMapper.writeValueAsString(requestDto);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("name", Arrays.asList("junwoo"));
        params.put("ps", Arrays.asList("1"));
        params.put("pn", Arrays.asList("2"));

        ResultActions perform = mockUseInitBinderMvc.perform(get(PATH + "/unused")
                        .params(params)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        perform.andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(responseBody));
    }

    @Test
    @DisplayName("@RequestBody X - InitBinder 사용하지 않은 QueryString Param Test")
    public void controller_non_use_init_binder_params_test() throws Exception {
        RequestDto responseDto = new RequestDto(null, 0, 0);
        String responseBody = objectMapper.writeValueAsString(responseDto);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("name", Arrays.asList("junwoo"));
        params.put("ps", Arrays.asList("1"));
        params.put("pn", Arrays.asList("2"));

        ResultActions perform = mockNonUseInitBinderMvc.perform(get(PATH + "/unused")
                .params(params)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        perform.andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(responseBody));
    }

}
