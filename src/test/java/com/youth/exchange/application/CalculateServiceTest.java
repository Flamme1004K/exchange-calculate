package com.youth.exchange.application;

import com.youth.exchange.application.dto.CalculateRequest;
import com.youth.exchange.application.dto.CalculateResponse;
import com.youth.exchange.domain.Exchange;
import com.youth.exchange.domain.ExchangeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {

    @InjectMocks
    CalculateService calculateService;

    @Mock
    ExchangeRepository exchangeRepository;

    @Test
    void 환율과_송금액을_이용하여_계산한다() {
        // given
        Optional<Exchange> exchange = Optional.of(new Exchange(1L, "USDAED", 3.673197, LocalDateTime.of(2022, 1, 1, 1, 1, 1)));
        CalculateRequest calculateRequest = new CalculateRequest(1L, 10000.0);

        // when
        when(exchangeRepository.findById(1L)).thenReturn(exchange);
        CalculateResponse result = calculateService.calculate(calculateRequest);

        // then
        assertThat(result.getResult()).isEqualTo(BigDecimal.valueOf(36731.97));
    }

    @Test
    void 송금액이_10000을_넘기는_경우_에러를_발생시킨다() {
        // given
        Optional<Exchange> exchange = Optional.of(new Exchange(1L, "USDAED", 3.673197, LocalDateTime.of(2022, 1, 1, 1, 1, 1)));
        CalculateRequest calculateRequest = new CalculateRequest(1L, 10001.0);

        // then
        assertThatIllegalArgumentException().isThrownBy(() -> calculateService.calculate(calculateRequest));
    }

}