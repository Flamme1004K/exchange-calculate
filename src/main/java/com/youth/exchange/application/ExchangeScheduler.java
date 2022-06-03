package com.youth.exchange.application;

import com.youth.exchange.domain.exchange.Exchange;
import com.youth.exchange.domain.exchange.ExchangeRepository;
import com.youth.exchange.domain.exchange.Exchanges;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeScheduler {

    private final ExchangePool exchangePool;
    private final ExchangeRepository exchangeRepository;

    @Scheduled(fixedDelay = 10000000, initialDelay = 1000)
    @Transactional
    public void exchangeSaveScheduler() {
        log.info("start exchangeSaveScheduler");
        Exchanges recentExchanges = exchangePool.getExchanges();
        exchangeRepository.saveAll(recentExchanges.getExchanges());
        log.info("ended exchangeSaveScheduler");
    }
}
