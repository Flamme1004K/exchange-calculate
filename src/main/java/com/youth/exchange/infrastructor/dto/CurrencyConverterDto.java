package com.youth.exchange.infrastructor.dto;

import com.youth.exchange.domain.Exchange;
import com.youth.exchange.domain.Exchanges;
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
                exchange -> new Exchange(exchange.getKey(), exchange.getValue(), renewalTime)
        ).collect(Collectors.toUnmodifiableList());

        return new Exchanges(elements);
    }

}
