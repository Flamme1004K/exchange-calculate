package com.youth.exchange.domain.exchange;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@NoArgsConstructor
public class Exchange {
    @Id
    private Long id;
    private String pair;
    private Float rate;
}
