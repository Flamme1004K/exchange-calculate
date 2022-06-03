package com.youth.exchange.infrastructor.dto;

import com.youth.exchange.domain.exchange.Exchange;
import com.youth.exchange.domain.exchange.Exchanges;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConverterDto {
    private Long timestamp;
    private String source;
    private Map<String, Float> quotes;

    public Exchanges toExchanges() {
        LocalDateTime renewalTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), TimeZone.getDefault().toZoneId());

        List<Exchange> elements = quotes.entrySet().stream().map(
                a -> new Exchange(a.getKey(), a.getValue(), renewalTime)
        ).collect(Collectors.toList());

        return new Exchanges(elements);
    }

}
