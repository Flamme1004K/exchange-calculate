package com.youth.exchange.application;

import com.youth.exchange.application.dto.ExchangeResponse;
import com.youth.exchange.domain.exchange.Exchange;
import com.youth.exchange.domain.exchange.ExchangeMock;
import com.youth.exchange.domain.exchange.ExchangeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExchangeViewServiceTest {

    @InjectMocks
    ExchangeViewService exchangeViewService;

    @Mock
    ExchangeRepository exchangeRepository;

    @Test
    void 환율_리스트는_최신_목록의_환율_기준으로_불러온다() {
        // given
        Exchange recentExchange = new Exchange(1L, "USDAED", 3.673197f, LocalDateTime.of(2022, 1, 1, 1, 1, 1));
        List<Exchange> recentRenewalExchanges = new ExchangeMock().getRecentRenewalExchanges(recentExchange.getRenewalTime());

        // when
        when(exchangeRepository.findTopByOrderByRenewalTime()).thenReturn(recentExchange);
        when(exchangeRepository.findAllByRenewalTime(recentExchange.getRenewalTime())).thenReturn(recentRenewalExchanges);
        List<ExchangeResponse> allExchange = exchangeViewService.getAllExchange();

        // then
        assertThat(allExchange.size()).isEqualTo(10);
    }
}