package com.youth.exchange.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RemittanceAmount {

    private final double amount;

    private static final double LIMIT_AMOUNT = 10000;

    public RemittanceAmount(double amount) {
        if (amount > LIMIT_AMOUNT) {
            throw new IllegalArgumentException("송금액은 10000원을 넘길 수 없습니다.");
        }
        this.amount = amount;
    }

    public BigDecimal changeTo(Exchange exchange) {
        return BigDecimal.valueOf(exchange.getRate()).multiply(BigDecimal.valueOf(this.amount))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
