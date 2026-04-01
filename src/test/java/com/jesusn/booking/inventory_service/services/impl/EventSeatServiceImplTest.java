package com.jesusn.booking.inventory_service.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.jesusn.booking.inventory_service.dtos.request.EventRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.EventResponseDTO;
import com.jesusn.booking.inventory_service.entities.Event;
import com.jesusn.booking.inventory_service.entities.PhysicalSeat;
import com.jesusn.booking.inventory_service.entities.Venue;
import com.jesusn.booking.inventory_service.mappers.EventMapper;
import com.jesusn.booking.inventory_service.repositories.EventRepository;
import com.jesusn.booking.inventory_service.repositories.EventSeatRepository;
import com.jesusn.booking.inventory_service.repositories.PhysicalSeatRepository;
import com.jesusn.booking.inventory_service.repositories.VenueRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    @Mock private EventRepository eventRepository;
    @Mock private VenueRepository venueRepository;
    @Mock private PhysicalSeatRepository physicalSeatRepository;
    @Mock private EventSeatRepository eventSeatRepository;
    @Mock private EventMapper eventMapper;

    @InjectMocks private EventServiceImpl eventService;

    @Test
    void createEvent_Success_GeneratesEventSeats() {

        Integer venueId = 1;
        EventRequestDTO request = new EventRequestDTO("Rock Fest", "SCHEDULED", venueId,LocalDateTime.now().plusYears(1), LocalDateTime.now());

        Venue mockVenue = new Venue();
        mockVenue.setId(venueId);

        Event mockEvent = new Event();
        mockEvent.setId(1);

        PhysicalSeat mockSeat1 = new PhysicalSeat();

        when(venueRepository.findById(venueId)).thenReturn(Optional.of(mockVenue));
        when(eventMapper.toEntity(request)).thenReturn(mockEvent);
        when(eventRepository.save(any(Event.class))).thenReturn(mockEvent);

        when(physicalSeatRepository.findByZoneVenueId(venueId)).thenReturn(List.of(mockSeat1));

        when(eventMapper.toDto(any(Event.class))).thenReturn(new EventResponseDTO(1, "Rock Fest", "SCHEDULED", null));

        // --- ACT
        EventResponseDTO result = eventService.createEvent(request);

        // --- ASSERT
        assertNotNull(result);
        assertEquals("Rock Fest", result.title());

        verify(eventSeatRepository, times(1)).saveAll(anyList());
    }
}