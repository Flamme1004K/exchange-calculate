package com.youth.exchange.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class RemittanceAmountTest {

    @Test
    void 송금액을_10000원_넘기면_에러를_발생시킨다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new RemittanceAmount(10001));
    }

    @ParameterizedTest
    @CsvSource(value = {"10000, 1121.419945, 11214199.45", "10000, 52.72027, 527202.70", "10000, 110.959498, 1109594.98", "10000, 10.000000, 100000.00"})
    void 환율을_통하여_송금액을_변경한다(double amount, double exchangeRate, BigDecimal expected) {
        // given
        RemittanceAmount remittanceAmount = new RemittanceAmount(amount);
        Exchange exchange = new Exchange("USDAED", exchangeRate, LocalDateTime.of(2022, 1, 1, 1, 1, 1));

        // when
        BigDecimal result = remittanceAmount.changeTo(exchange);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 환율을_통하여_송금액을_변경한_경우_세번째_숫자가_5_이상인_경우_반올림_된다() {
        // given
        RemittanceAmount remittanceAmount = new RemittanceAmount(10000);
        Exchange exchange = new Exchange("USDAED", 1121.4199457, LocalDateTime.of(2022, 1, 1, 1, 1, 1));

        // when
        BigDecimal result = remittanceAmount.changeTo(exchange);

        // then
        assertThat(result).isEqualTo(BigDecimal.valueOf(11214199.46));
    }
}