package com.jesusn.booking.inventory_service.controllers;

import com.jesusn.booking.inventory_service.dtos.request.ZoneRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.ZoneResponseDTO;
import com.jesusn.booking.inventory_service.services.ZoneService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/zones")
@RequiredArgsConstructor
public class ZoneController {

    private final ZoneService zoneService;

    @PostMapping
    public ResponseEntity<ZoneResponseDTO> createZone(@Valid @RequestBody ZoneRequestDTO requestDTO) {
        ZoneResponseDTO response = zoneService.createZone(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ZoneResponseDTO>> getAllZones() {
        List<ZoneResponseDTO> responses = zoneService.getAllZones();
        return ResponseEntity.ok(responses);
    }
}