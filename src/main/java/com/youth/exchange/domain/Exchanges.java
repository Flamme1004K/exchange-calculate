package com.youth.exchange.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Exchanges {

    private final List<Exchange> elements;

    public Exchanges(List<Exchange> exchanges) {
        this.elements = exchanges;
    }

}
