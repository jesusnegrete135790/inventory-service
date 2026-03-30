package com.jesusn.booking.inventory_service.services.impl;

import com.jesusn.booking.inventory_service.dtos.request.PhysicalSeatRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.PhysicalSeatResponseDTO;
import com.jesusn.booking.inventory_service.entities.PhysicalSeat;
import com.jesusn.booking.inventory_service.entities.Zone;
import com.jesusn.booking.inventory_service.exceptions.ResourceNotFoundException;
import com.jesusn.booking.inventory_service.mappers.PhysicalSeatMapper;
import com.jesusn.booking.inventory_service.repositories.PhysicalSeatRepository;
import com.jesusn.booking.inventory_service.repositories.ZoneRepository;
import com.jesusn.booking.inventory_service.services.PhysicalSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhysicalSeatServiceImpl implements PhysicalSeatService {

    private final PhysicalSeatRepository physicalSeatRepository;
    private final ZoneRepository zoneRepository;
    private final PhysicalSeatMapper physicalSeatMapper;

    @Override
    @Transactional
    public PhysicalSeatResponseDTO createPhysicalSeat(PhysicalSeatRequestDTO requestDTO) {

        Zone zone = zoneRepository.findById(requestDTO.zoneId())
                .orElseThrow(() -> new ResourceNotFoundException("Zone not found with id: " + requestDTO.zoneId()));

        PhysicalSeat seatToSave = physicalSeatMapper.toEntity(requestDTO);

        seatToSave.setZone(zone);

        PhysicalSeat savedSeat = physicalSeatRepository.save(seatToSave);
        return physicalSeatMapper.toDto(savedSeat);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PhysicalSeatResponseDTO> getPhysicalSeatsByZoneId(Integer zoneId) {

        if (!zoneRepository.existsById(zoneId)) {
            throw new ResourceNotFoundException("Zone not found with id: " + zoneId);
        }
        return physicalSeatMapper.toDtoList(physicalSeatRepository.findByZoneId(zoneId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PhysicalSeatResponseDTO> getAllPhysicalSeats() {
        return physicalSeatMapper.toDtoList(physicalSeatRepository.findAll());
    }

}