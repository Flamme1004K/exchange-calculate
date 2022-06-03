package com.youth.exchange.domain.exchange;

import lombok.Getter;

import java.util.List;

@Getter
public class Exchanges {

    private final List<Exchange> exchanges;

    public Exchanges(List<Exchange> exchanges) {
        this.exchanges = exchanges;
    }
}
