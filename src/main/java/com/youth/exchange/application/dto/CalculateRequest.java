package com.youth.exchange.application.dto;

import lombok.Getter;

@Getter
public class CalculateRequest {
    private final Long exchangeId;
    private final Double amount;

    public CalculateRequest(Long exchangeId, Double amount) {
        this.exchangeId = exchangeId;
        this.amount = amount;
    }
}
