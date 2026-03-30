package com.jesusn.booking.inventory_service.services;

import com.jesusn.booking.inventory_service.dtos.request.PhysicalSeatRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.PhysicalSeatResponseDTO;

import java.util.List;

public interface PhysicalSeatService {
    PhysicalSeatResponseDTO createPhysicalSeat(PhysicalSeatRequestDTO requestDTO);

    List<PhysicalSeatResponseDTO> getAllPhysicalSeats();

    List<PhysicalSeatResponseDTO> getPhysicalSeatsByZoneId(Integer zoneId);
}
