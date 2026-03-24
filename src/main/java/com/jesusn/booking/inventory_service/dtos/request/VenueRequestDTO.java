package com.jesusn.booking.inventory_service.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record VenueRequestDTO (
        @NotBlank
        String name,

        @NotBlank
        String city,

        @NotBlank
        String address,

        @NotNull
        LocalDateTime createdAt){
}
