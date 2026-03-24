package com.jesusn.booking.inventory_service.dtos.response;

import java.time.LocalDateTime;

public record EventResponseDTO (Integer id,
                                String title,
                                String status,
                                LocalDateTime eventDate){
}
