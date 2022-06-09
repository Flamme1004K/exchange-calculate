package com.youth.exchange.infrastructor;

import com.youth.exchange.application.ExchangePool;
import com.youth.exchange.domain.Exchanges;
import com.youth.exchange.infrastructor.dto.CurrencyConverterDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurrencyConverterExchangePool implements ExchangePool {

    private final RestTemplate restTemplate;

    @Value("${currency_data.url}")
    private String URL;

    @Value("${currency_data.header.key}")
    private String KEY;

    @Value("${currency_data.header.value}")
    private String VALUE;

    @Override
    public Exchanges getExchanges() {
        ResponseEntity<CurrencyConverterDto> response = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                setHeader(),
                CurrencyConverterDto.class
        );
        return Objects.requireNonNull(response.getBody()).toExchanges();
    }

    private HttpEntity<MultiValueMap<String, String>> setHeader() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add(KEY, VALUE);
        return new HttpEntity<>(map);
    }
}
