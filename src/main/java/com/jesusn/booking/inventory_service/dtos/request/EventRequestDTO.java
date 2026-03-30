package com.jesusn.booking.inventory_service.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EventRequestDTO (
        @NotBlank
        String title,
        @NotBlank
        String status,
        @NotNull
        Integer venueId,
        LocalDateTime eventDate,
        LocalDateTime createdAt){
}
