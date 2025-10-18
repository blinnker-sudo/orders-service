package com.acme.orders.api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record OrderCreateDto(
        @NotNull @Email String email,
        @NotNull @DecimalMin(value = "0.01") BigDecimal amount
        ) {
}
