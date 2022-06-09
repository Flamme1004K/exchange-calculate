package com.youth.exchange.domain.exchange;

import com.youth.exchange.domain.Exchange;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ExchangeMock {

    private static final List<Exchange> exchanges = List.of(
            new Exchange(1L, "USDAED", 3.673197f, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(2L, "USDAFN", 76.088502f, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(3L, "USDALL", 108.014949f, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(4L, "USDAMD", 484.684999f, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(5L, "USDANG", 1.78935f, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(6L, "USDAOA", 308.428019f, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(7L, "USDARS", 38.025498f, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(8L, "USDAUD", 1.41645f, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(9L, "USDAWG", 1.8005f, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(10L, "USDAZN", 1.704992f, LocalDateTime.of(2022, 1, 1, 1, 1, 1))
    );

    public List<Exchange> getRecentRenewalExchanges(LocalDateTime localDateTime) {
        return exchanges.stream()
                .filter(exchange -> exchange.getRenewalTime().isEqual(localDateTime))
                .collect(Collectors.toList());
    }
}
