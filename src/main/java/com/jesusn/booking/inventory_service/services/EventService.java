package com.jesusn.booking.inventory_service.services;

import com.jesusn.booking.inventory_service.dtos.request.EventRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.EventResponseDTO;

import java.util.List;

public interface EventService {
    EventResponseDTO createEvent(EventRequestDTO requestDTO);
    List<EventResponseDTO> getAllEvents();
    EventResponseDTO getEventById(Integer id);
}
