package com.jesusn.booking.inventory_service.services;

import com.jesusn.booking.inventory_service.dtos.response.EventSeatResponseDTO;

import java.util.List;

public interface EventSeatService {

    List<EventSeatResponseDTO> getSeatsByEventId(Integer eventId);

    EventSeatResponseDTO lockSeat(Integer seatId);

}
