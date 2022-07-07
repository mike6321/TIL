package com.example.testcode.study.request_body_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(value = MockitoExtension.class)
@ActiveProfiles("test")
public class RequestControllerUnitTest {

    private static final String PATH = "/primitive-test";
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    @InjectMocks
    private RequestController requestController;

    @BeforeEach
    void setUp() {
        setUpMockMvcStandAlone();
        setUpObjectMapper();
    }

    private void setUpObjectMapper() {
        objectMapper= new ObjectMapper().registerModule(new JavaTimeModule());
    }

    private void setUpMockMvcStandAlone() {
//        HandlerMethodArgumentResolverComposite handlerMethodArgumentResolverComposite = new HandlerMethodArgumentResolverComposite();
//        handlerMethodArgumentResolverComposite.clear();
//        ServletModelAttributeMethodProcessor servletModelAttributeMethodProcessor = new ServletModelAttributeMethodProcessor(false);
//        handlerMethodArgumentResolverComposite.addResolvers(new RequestResponseBodyMethodProcessor(List.of(new MappingJackson2HttpMessageConverter())));
//        handlerMethodArgumentResolverComposite.addResolver(new HandlerMethodArgumentResolverComposite());
//        handlerMethodArgumentResolverComposite.addResolver(servletModelAttributeMethodProcessor);
        mockMvc = MockMvcBuilders.standaloneSetup(requestController)
                .setControllerAdvice(WebControllerAdvice.class)
//                .setCustomArgumentResolvers(new HandlerMethodArgumentResolverComposite())
//                .setMessageConverters(new MappingJackson2HttpMessageConverter())
//                .setCustomArgumentResolvers(handlerMethodArgumentResolverComposite)
                .build();
    }

    @Test
    public void controller_content_test() throws Exception {
        RequestDto requestDto = new RequestDto("junwoo", 1, 2);
        String requestBody = objectMapper.writeValueAsString(requestDto);
        String responseBody = objectMapper.writeValueAsString(requestDto);
        ResultActions perform = mockMvc.perform(get(PATH)
                        .queryParam("requestDto", requestBody)
                .contentType(MediaType.APPLICATION_JSON));

        perform.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(content().string(responseBody))
                .andDo(print());
    }

    @Test
    public void controller_params_test() throws Exception {
        RequestDto requestDto = new RequestDto("junwoo", 1, 2);
        String responseBody = objectMapper.writeValueAsString(requestDto);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("name", Arrays.asList("junwoo"));
        params.put("ps", Arrays.asList("1"));
        params.put("pn", Arrays.asList("2"));

        ResultActions perform = mockMvc.perform(get(PATH)
                        .params(params)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        perform.andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(responseBody));
    }

}
