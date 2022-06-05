package com.youth.exchange.application;

import com.youth.exchange.domain.exchange.Exchange;
import com.youth.exchange.domain.exchange.ExchangeRepository;
import com.youth.exchange.domain.exchange.Exchanges;
import com.youth.exchange.application.dto.ExchangeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeViewService {

    private final ExchangeRepository exchangeRepository;

    public List<ExchangeResponse> getAllExchange() {
        LocalDateTime recentRenewalTime = exchangeRepository.findTopByOrderByRenewalTime().getRenewalTime();
        List<Exchange> exchanges = exchangeRepository.findAllByRenewalTime(recentRenewalTime);
        return ExchangeResponse.of(exchanges);
    }
}
