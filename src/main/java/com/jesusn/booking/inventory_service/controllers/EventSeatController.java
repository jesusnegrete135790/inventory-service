package com.jesusn.booking.inventory_service.controllers;

import com.jesusn.booking.inventory_service.dtos.response.EventSeatResponseDTO;
import com.jesusn.booking.inventory_service.services.EventSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event-seats")
@RequiredArgsConstructor
public class EventSeatController {

    private final EventSeatService eventSeatService;

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<EventSeatResponseDTO>> getSeatsByEventId(@PathVariable Integer eventId) {
        List<EventSeatResponseDTO> responses = eventSeatService.getSeatsByEventId(eventId);
        System.out.println("Peticion enviada get");
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}/lock")
    public ResponseEntity<EventSeatResponseDTO> lockSeat(@PathVariable Integer id) {
        EventSeatResponseDTO response = eventSeatService.lockSeat(id);
        System.out.println("Peticion enviada post");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventSeatResponseDTO> getSeatById(@PathVariable Integer id) {

        EventSeatResponseDTO response = eventSeatService.getSeatById(id);
        System.out.println("Peticion enviada get by ID");
        return ResponseEntity.ok(response);
    }
}