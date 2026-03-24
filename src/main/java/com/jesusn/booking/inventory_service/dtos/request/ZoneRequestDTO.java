package com.jesusn.booking.inventory_service.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ZoneRequestDTO (
        @Positive
        @NotNull
        Integer capacity,

        @NotBlank
        String name,

        @NotNull
        Integer venueId){
}
