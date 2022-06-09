package com.youth.exchange.domain.exchange;

import com.youth.exchange.domain.Exchange;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ExchangeMock {

    private static final List<Exchange> exchanges = List.of(
            new Exchange(1L, "USDAED", 3.673197, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(2L, "USDAFN", 76.088502, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(3L, "USDALL", 108.014949, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(4L, "USDAMD", 484.684999, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(5L, "USDANG", 1.78935, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(6L, "USDAOA", 308.428019, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(7L, "USDARS", 38.025498, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(8L, "USDAUD", 1.41645, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(9L, "USDAWG", 1.8005, LocalDateTime.of(2022, 1, 1, 1, 1, 1)),
            new Exchange(10L, "USDAZN", 1.704992, LocalDateTime.of(2022, 1, 1, 1, 1, 1))
    );

    public List<Exchange> getRecentRenewalExchanges(LocalDateTime localDateTime) {
        return exchanges.stream()
                .filter(exchange -> exchange.getRenewalTime().isEqual(localDateTime))
                .collect(Collectors.toList());
    }
}
