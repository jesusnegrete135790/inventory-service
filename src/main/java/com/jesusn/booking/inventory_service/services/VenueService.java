package com.jesusn.booking.inventory_service.services;

import com.jesusn.booking.inventory_service.dtos.request.VenueRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.VenueResponseDTO;

import java.util.List;

public interface VenueService {

    VenueResponseDTO createVenue(VenueRequestDTO requestDTO);
    List<VenueResponseDTO> getAllVenues();

}
