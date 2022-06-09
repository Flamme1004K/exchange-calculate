package com.youth.exchange.application.dto;

import com.youth.exchange.domain.Exchange;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ExchangeResponse {
    private Long id;
    private String pair;
    private Float rate;

    public static List<ExchangeResponse> of(List<Exchange> exchanges) {
        return exchanges.stream().map(ExchangeResponse::of).collect(Collectors.toUnmodifiableList());
    }

    public static ExchangeResponse of(Exchange exchange) {
        return new ExchangeResponse(exchange.getId(), exchange.getPair(), exchange.getRate());
    }
}
