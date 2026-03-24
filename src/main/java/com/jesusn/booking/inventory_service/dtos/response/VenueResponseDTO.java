package com.jesusn.booking.inventory_service.dtos.response;

import java.time.LocalDateTime;

public record VenueResponseDTO (Integer id,
                                String name,
                                String city,
                                String address,
                                LocalDateTime createdAt){
}
