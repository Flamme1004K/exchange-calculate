package com.youth.exchange.application.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CalculateResponse {
    private final BigDecimal result;

    public CalculateResponse(BigDecimal result) {
        this.result = result;
    }
}
