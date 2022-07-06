package com.example.testcode.study.restdoc;

import com.example.testcode.study.restdoc.production.RestDocTestController;
import com.example.testcode.study.restdoc.production.TestRequestDto;
import com.example.testcode.study.restdoc.production.RestDocTestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.example.testcode.study.restdoc.ApiDocumentUtils.getDocumentRequest;
import static com.example.testcode.study.restdoc.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(value = {MockitoExtension.class, RestDocumentationExtension.class})
@ActiveProfiles("test")
public class ControllerTest {

    private static final String PATH = "/test/";

    @InjectMocks
    private RestDocTestController restDocTestController;
    @Mock
    private RestDocTestService restDocTestService;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(RestDocumentationContextProvider restDocumentationContextProvider) {
        setUpMockMvcStandAlone(restDocumentationContextProvider);
        setUpObjectMapper();
    }

    private void setUpObjectMapper() {
        objectMapper= new ObjectMapper().registerModule(new JavaTimeModule());
    }

    private void setUpMockMvcStandAlone(RestDocumentationContextProvider restDocumentationContextProvider) {
        mockMvc = MockMvcBuilders.standaloneSetup(restDocTestController)
                .apply(documentationConfiguration(restDocumentationContextProvider))
                .build();
    }

    @Test
    public void controller_test() throws Exception {
        // given
        TestRequestDto testRequestDto = new TestRequestDto(1L, "name");
        String requestBody = objectMapper.writeValueAsString(testRequestDto);
        String responseBody = objectMapper.writeValueAsString(testRequestDto);
        given(restDocTestService.getMethod(any(TestRequestDto.class))).willReturn(testRequestDto);
        // when
        ResultActions perform = mockMvc.perform(get(PATH + "{testId}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));
        // then
        perform.andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(responseBody));
        //document
        perform.andDo(document("test-get",
                getDocumentRequest(),
                getDocumentResponse(),
//                requestHeaders(
//                        headerWithName(HttpHeaders.AUTHORIZATION).description("Bearer Token")
//                ),
                pathParameters(
                        parameterWithName("testId").description("test id")
                ),
                requestFields(
                        fieldWithPath("id").type(Long.class).description("test id"),
                        fieldWithPath("name").type(String.class).description("tes name")
                ),
                responseFields(
                        fieldWithPath("id").type(Long.class).description("test id"),
                        fieldWithPath("name").type(String.class).description("tes name")
                )));
    }


}
