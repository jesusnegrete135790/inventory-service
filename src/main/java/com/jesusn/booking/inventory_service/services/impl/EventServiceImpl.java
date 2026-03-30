package com.jesusn.booking.inventory_service.services.impl;

import com.jesusn.booking.inventory_service.dtos.request.EventRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.EventResponseDTO;
import com.jesusn.booking.inventory_service.entities.Event;
import com.jesusn.booking.inventory_service.entities.EventSeat;
import com.jesusn.booking.inventory_service.entities.PhysicalSeat;
import com.jesusn.booking.inventory_service.entities.Venue;
import com.jesusn.booking.inventory_service.exceptions.ResourceNotFoundException;
import com.jesusn.booking.inventory_service.mappers.EventMapper;
import com.jesusn.booking.inventory_service.repositories.EventRepository;
import com.jesusn.booking.inventory_service.repositories.EventSeatRepository;
import com.jesusn.booking.inventory_service.repositories.PhysicalSeatRepository;
import com.jesusn.booking.inventory_service.repositories.VenueRepository;
import com.jesusn.booking.inventory_service.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    private final EventMapper eventMapper;
    private final PhysicalSeatRepository physicalSeatRepository;
    private final EventSeatRepository eventSeatRepository;


    @Override
    @Transactional(readOnly = true)
    public List<EventResponseDTO> getAllEvents() {
        return eventMapper.toDtoList(eventRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public EventResponseDTO getEventById(Integer id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
        return eventMapper.toDto(event);
    }

    @Override
    @Transactional
    public EventResponseDTO createEvent(EventRequestDTO requestDTO) {

        Venue venue = venueRepository.findById(requestDTO.venueId())
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found with id: " + requestDTO.venueId()));

        Event eventToSave = eventMapper.toEntity(requestDTO);
        eventToSave.setVenue(venue);
        eventToSave.setCreatedAt(LocalDateTime.now());
        Event savedEvent = eventRepository.save(eventToSave);


        List<PhysicalSeat> physicalSeats =  physicalSeatRepository.findByZoneVenueId(venue.getId());

        List<EventSeat> eventSeatsToGenerate = physicalSeats.stream().map(physicalSeat -> {
            EventSeat eventSeat = new EventSeat();
            eventSeat.setEvent(savedEvent);
            eventSeat.setPhysicalSeat(physicalSeat);
            eventSeat.setStatus("AVAILABLE");
            eventSeat.setPrice(BigDecimal.ZERO);

            return eventSeat;
        }).toList();

        eventSeatRepository.saveAll(eventSeatsToGenerate);

        return eventMapper.toDto(savedEvent);
    }
}