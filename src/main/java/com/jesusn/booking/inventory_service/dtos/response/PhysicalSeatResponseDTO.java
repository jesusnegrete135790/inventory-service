package com.jesusn.booking.inventory_service.dtos.response;

public record PhysicalSeatResponseDTO ( Integer id,
                                        Integer seatNumber,
                                        String rowLetter,
                                        Integer zoneId){
}
