package com.jesusn.booking.inventory_service.dtos.response;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

public record ZoneResponseDTO ( Integer id,
                                Integer capacity,
                                String name,
                                Integer venueId){
}
