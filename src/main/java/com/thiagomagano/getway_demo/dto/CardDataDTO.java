package com.thiagomagano.getway_demo.dto;

public record CardDataDTO(
    String number,
    String holderName,
    String expiryDate,
    String cvv
) {}
