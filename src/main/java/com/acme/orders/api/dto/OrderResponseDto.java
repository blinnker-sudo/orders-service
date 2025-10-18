package com.acme.orders.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record OrderResponseDto(
        Long id,
        String email,
        BigDecimal amount,
        String status,
        OffsetDateTime createdAt
) {}
