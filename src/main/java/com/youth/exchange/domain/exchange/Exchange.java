package com.youth.exchange.domain.exchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Exchange {
    @Id
    private Long id;
    private String pair;
    private Float rate;

    protected Exchange() {

    }
}
