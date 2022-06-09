package com.youth.exchange.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
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
        this(null, pair, rate, renewalTime);
    }

    public Exchange(Long id, String pair, Float rate, LocalDateTime renewalTime) {
        this.id = id;
        this.pair = pair;
        this.rate = rate;
        this.renewalTime = renewalTime;
    }
}
