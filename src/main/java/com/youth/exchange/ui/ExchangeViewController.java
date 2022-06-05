package com.youth.exchange.ui;

import com.youth.exchange.application.ExchangeViewService;
import com.youth.exchange.application.dto.ExchangeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExchangeViewController {

    private final ExchangeViewService service;

    @GetMapping("list")
    public ResponseEntity<List<ExchangeResponse>> all() {
        return ResponseEntity.ok(service.getAllExchange());
    }
}
