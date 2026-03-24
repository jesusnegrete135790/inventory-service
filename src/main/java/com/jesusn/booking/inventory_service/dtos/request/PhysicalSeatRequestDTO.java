package com.jesusn.booking.inventory_service.dtos.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PhysicalSeatRequestDTO (
        @NotNull
        Integer seatNumber,

        @NotBlank
        String rowLetter,

        @NotNull
        @Positive
        Integer zoneId){
}


