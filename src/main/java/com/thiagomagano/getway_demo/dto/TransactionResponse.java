package com.thiagomagano.getway_demo.dto;

import java.util.UUID;
import org.springframework.transaction.TransactionStatus;

public record TransactionResponse(
    UUID transactionId,
    TransactionStatus status,
    String message,
    String nsu,
    String authorizationCode
) {}
