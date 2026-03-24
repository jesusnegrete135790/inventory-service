package com.jesusn.booking.inventory_service.dtos.response;

import java.math.BigDecimal;

public record EventSeatResponseDTO (Integer id,
                                    Integer version,
                                    BigDecimal price,
                                    String status,
                                    Integer eventId,
                                    Integer physicalSeatId){
}
