package com.youth.exchange.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youth.exchange.application.CalculateService;
import com.youth.exchange.application.dto.CalculateRequest;
import com.youth.exchange.application.dto.CalculateResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculateController.class)
public class CalculateControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CalculateService service;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void 환율을_계산하는_API를_테스트한다() throws Exception {
        // given
        CalculateRequest calculateRequest = new CalculateRequest(1L, 10000.00);
        CalculateResponse calculateResponse = new CalculateResponse(BigDecimal.valueOf(1234.567));
        String param = objectMapper.writeValueAsString(calculateRequest);
        given(service.calculate(any())).willReturn(calculateResponse);

        // when
        ResultActions perform = mockMvc.perform(
                post("/calculate")
                        .content(param)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        // then
        perform.andExpect(status().isOk())
                .andExpect(jsonPath("result").value(BigDecimal.valueOf(1234.567)))
                .andDo(print());
    }

}