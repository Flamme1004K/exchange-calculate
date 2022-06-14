package com.youth.exchange.ui;

import com.youth.exchange.application.CalculateService;
import com.youth.exchange.application.dto.CalculateRequest;
import com.youth.exchange.application.dto.CalculateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculateController {

    private final CalculateService service;

    @PostMapping("/calculate")
    public ResponseEntity<CalculateResponse> calculate(@RequestBody CalculateRequest request) {
        CalculateResponse result = service.calculate(request);
        return ResponseEntity.ok(result);
    }
}
