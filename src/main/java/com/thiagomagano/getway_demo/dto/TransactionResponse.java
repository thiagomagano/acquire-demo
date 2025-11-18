package com.thiagomagano.getway_demo.dto;

import com.thiagomagano.getway_demo.domain.enums.TransactionStatus;
import java.util.UUID;

public record TransactionResponse(
    UUID transactionId,
    TransactionStatus status,
    String message,
    String nsu,
    String authorizationCode
) {}
