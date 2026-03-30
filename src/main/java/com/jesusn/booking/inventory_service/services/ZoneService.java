package com.jesusn.booking.inventory_service.services;

import com.jesusn.booking.inventory_service.dtos.request.ZoneRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.ZoneResponseDTO;

import java.util.List;

public interface ZoneService {
    ZoneResponseDTO createZone(ZoneRequestDTO requestDTO);
    List<ZoneResponseDTO> getAllZones();
    List<ZoneResponseDTO> getZonesByVenueId(Integer venueId);
}