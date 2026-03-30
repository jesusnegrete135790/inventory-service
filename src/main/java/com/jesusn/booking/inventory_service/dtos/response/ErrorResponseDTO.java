package com.jesusn.booking.inventory_service.dtos.response;

import java.time.LocalDateTime;

public record ErrorResponseDTO (String message,
                                String details,
                                LocalDateTime timestamp){
}
