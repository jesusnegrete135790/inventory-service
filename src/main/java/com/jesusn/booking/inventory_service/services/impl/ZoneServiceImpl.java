package com.jesusn.booking.inventory_service.services.impl;

import com.jesusn.booking.inventory_service.dtos.request.ZoneRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.ZoneResponseDTO;
import com.jesusn.booking.inventory_service.entities.Venue;
import com.jesusn.booking.inventory_service.entities.Zone;
import com.jesusn.booking.inventory_service.mappers.ZoneMapper;
import com.jesusn.booking.inventory_service.repositories.VenueRepository;
import com.jesusn.booking.inventory_service.repositories.ZoneRepository;
import com.jesusn.booking.inventory_service.services.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZoneServiceImpl implements ZoneService {

    private final ZoneRepository zoneRepository;
    private final VenueRepository venueRepository;
    private final ZoneMapper zoneMapper;

    @Override
    @Transactional
    public ZoneResponseDTO createZone(ZoneRequestDTO requestDTO) {

        Venue venue = venueRepository.findById(requestDTO.venueId())
                .orElseThrow(() -> new RuntimeException("Venue not found with id: " + requestDTO.venueId()));

        Zone zoneToSave = zoneMapper.toEntity(requestDTO);

        zoneToSave.setVenue(venue);

        Zone savedZone = zoneRepository.save(zoneToSave);
        return zoneMapper.toDto(savedZone);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ZoneResponseDTO> getAllZones() {
        return zoneMapper.toDtoList(zoneRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ZoneResponseDTO> getZonesByVenueId(Integer venueId) {
        return null;
    }
}