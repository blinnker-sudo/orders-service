package com.acme.orders.api.dto;

import jakarta.validation.constraints.NotBlank;

public record OrderUpdateDto(
        @NotBlank String status
) {}
