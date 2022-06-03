package com.youth.exchange.domain.exchange;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pair;
    private Float rate;
    private LocalDateTime renewalTime;

    public Exchange(String pair, Float rate, LocalDateTime renewalTime) {
        this.pair = pair;
        this.rate = rate;
        this.renewalTime = renewalTime;
    }
}
