package com.jesusn.booking.inventory_service.controllers;

import com.jesusn.booking.inventory_service.dtos.request.PhysicalSeatRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.PhysicalSeatResponseDTO;
import com.jesusn.booking.inventory_service.services.PhysicalSeatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/physical-seats")
@RequiredArgsConstructor
public class PhysicalSeatController {

    private final PhysicalSeatService physicalSeatService;

    @PostMapping
    public ResponseEntity<PhysicalSeatResponseDTO> createPhysicalSeat(@Valid @RequestBody PhysicalSeatRequestDTO requestDTO) {
        PhysicalSeatResponseDTO response = physicalSeatService.createPhysicalSeat(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PhysicalSeatResponseDTO>> getAllPhysicalSeats() {
        List<PhysicalSeatResponseDTO> responses = physicalSeatService.getAllPhysicalSeats();
        return ResponseEntity.ok(responses);
    }


    @GetMapping("/zone/{zoneId}")
    public ResponseEntity<List<PhysicalSeatResponseDTO>> getPhysicalSeatsByZoneId(@PathVariable Integer zoneId) {
        List<PhysicalSeatResponseDTO> responses = physicalSeatService.getPhysicalSeatsByZoneId(zoneId);
        return ResponseEntity.ok(responses);
    }

}