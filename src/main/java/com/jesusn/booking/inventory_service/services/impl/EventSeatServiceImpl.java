package com.jesusn.booking.inventory_service.services.impl;

import com.jesusn.booking.inventory_service.dtos.response.EventSeatResponseDTO;
import com.jesusn.booking.inventory_service.entities.EventSeat;
import com.jesusn.booking.inventory_service.exceptions.ResourceNotFoundException;
import com.jesusn.booking.inventory_service.mappers.EventSeatMapper;
import com.jesusn.booking.inventory_service.repositories.EventRepository;
import com.jesusn.booking.inventory_service.repositories.EventSeatRepository;
import com.jesusn.booking.inventory_service.services.EventSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventSeatServiceImpl implements EventSeatService {

    private final EventSeatRepository eventSeatRepository;
    private final EventRepository eventRepository;
    private final EventSeatMapper eventSeatMapper;

    @Override
    @Transactional(readOnly = true)
    public List<EventSeatResponseDTO> getSeatsByEventId(Integer eventId) {
        if (!eventRepository.existsById(eventId)) {
            throw new ResourceNotFoundException("Event not found with id: " + eventId);
        }
        return eventSeatMapper.toDtoList(eventSeatRepository.findByEventId(eventId));
    }

    @Override
    public EventSeatResponseDTO getSeatById(Integer eventId) {
        EventSeat seat = eventSeatRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event Seat not found with id: " + eventId));
        return eventSeatMapper.toDto(seat);
    }

    @Override
    @Transactional
    public EventSeatResponseDTO lockSeat(Integer seatId) {
        EventSeat seat = eventSeatRepository.findById(seatId)
                .orElseThrow(() -> new ResourceNotFoundException("Event Seat not found with id: " + seatId));

        if (!"AVAILABLE".equals(seat.getStatus())) {
            throw new IllegalStateException("Seat is no longer available. Current status: " + seat.getStatus());
        }

        seat.setStatus("LOCKED");

        EventSeat lockedSeat = eventSeatRepository.save(seat);

        return eventSeatMapper.toDto(lockedSeat);
    }
}