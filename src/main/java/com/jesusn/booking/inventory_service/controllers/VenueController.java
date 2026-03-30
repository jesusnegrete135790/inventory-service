package com.jesusn.booking.inventory_service.controllers;

import com.jesusn.booking.inventory_service.dtos.request.VenueRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.VenueResponseDTO;
import com.jesusn.booking.inventory_service.services.VenueService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class VenueController {

    private final VenueService venueService;

    @PostMapping
    public ResponseEntity<VenueResponseDTO> createVenue(@Valid @RequestBody VenueRequestDTO requestDTO) {
        VenueResponseDTO response = venueService.createVenue(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VenueResponseDTO>> getAllVenues() {
        List<VenueResponseDTO> responses = venueService.getAllVenues();
        return ResponseEntity.ok(responses);
    }
}