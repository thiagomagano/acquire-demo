package com.thiagomagano.getway_demo.controller;

import com.thiagomagano.getway_demo.dto.TransactionRequest;
import com.thiagomagano.getway_demo.dto.TransactionResponse;
import com.thiagomagano.getway_demo.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(
        @RequestBody TransactionRequest request
    ) {
        TransactionResponse response = service.process(request);
        return ResponseEntity.ok(response);
    }
}
