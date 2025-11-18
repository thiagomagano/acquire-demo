package com.thiagomagano.getway_demo.dto;

import java.math.BigDecimal;

public record TransactionRequest(
    String merchantId,
    BigDecimal amount,
    String currency,
    String paymentMethod,
    CardDataDTO card
) {}
