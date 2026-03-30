package com.jesusn.booking.inventory_service.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record EventSeatRequestDTO (
        @NotNull
        Integer version,

        @NotNull
        @Positive
        BigDecimal price,

        @NotBlank
        String status,

        @NotNull
        Integer eventId,
        @NotNull
        Integer physicalSeatId
){
}
