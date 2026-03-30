package com.jesusn.booking.inventory_service.services.impl;

import com.jesusn.booking.inventory_service.dtos.request.VenueRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.VenueResponseDTO;
import com.jesusn.booking.inventory_service.entities.Venue;
import com.jesusn.booking.inventory_service.mappers.VenueMapper;
import com.jesusn.booking.inventory_service.repositories.VenueRepository;
import com.jesusn.booking.inventory_service.services.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;
    private final VenueMapper venueMapper;


    @Override
    @Transactional
    public VenueResponseDTO createVenue(VenueRequestDTO requestDTO) {

        Venue venueToSave = venueMapper.toEntity(requestDTO);
        venueToSave.setCreatedAt(LocalDateTime.now());

        Venue savedVenue = venueRepository.save(venueToSave);

        return venueMapper.toDto(savedVenue);
    }

    @Override
    @Transactional(readOnly = true) // readOnly = true optimiza las consultas de solo lectura
    public List<VenueResponseDTO> getAllVenues() {

        List<Venue> venues = venueRepository.findAll();

        return venueMapper.toDtoList(venues);
    }
}