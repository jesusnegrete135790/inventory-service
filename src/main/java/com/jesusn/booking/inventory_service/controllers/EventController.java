package com.jesusn.booking.inventory_service.controllers;

import com.jesusn.booking.inventory_service.dtos.request.EventRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.EventResponseDTO;
import com.jesusn.booking.inventory_service.services.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<EventResponseDTO> createEvent(@Valid @RequestBody EventRequestDTO requestDTO) {
        EventResponseDTO response = eventService.createEvent(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getAllEvents() {
        List<EventResponseDTO> responses = eventService.getAllEvents();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEventById(@PathVariable Integer id) {
        EventResponseDTO response = eventService.getEventById(id);
        return ResponseEntity.ok(response);
    }
}