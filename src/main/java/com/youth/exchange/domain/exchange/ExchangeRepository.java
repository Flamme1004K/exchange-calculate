package com.youth.exchange.domain.exchange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    Exchange findTopByOrderByRenewalTime();
    List<Exchange> findAllByRenewalTime(LocalDateTime renewalTime);

}
