package com.youth.exchange.application;

import com.youth.exchange.application.dto.CalculateRequest;
import com.youth.exchange.application.dto.CalculateResponse;
import com.youth.exchange.domain.Exchange;
import com.youth.exchange.domain.ExchangeRepository;
import com.youth.exchange.domain.RemittanceAmount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CalculateService {

    private final ExchangeRepository repository;

    public CalculateResponse calculate(CalculateRequest request) {
        final Exchange exchange = repository.findById(request.getExchangeId()).orElseThrow(() -> new IllegalArgumentException("해당 환율 내역이 없습니다."));
        RemittanceAmount remittanceAmount = new RemittanceAmount(request.getAmount());
        BigDecimal result = remittanceAmount.changeTo(exchange);
        return new CalculateResponse(result);
    }
}
