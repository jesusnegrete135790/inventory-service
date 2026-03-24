package com.jesusn.booking.inventory_service.dtos.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record EventRequestDTO (
        @NotBlank
        String title,
        @NotBlank
        String status,
        LocalDateTime eventDate,
        LocalDateTime createdAt){
}
