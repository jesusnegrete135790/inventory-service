package com.jesusn.booking.inventory_service.mappers;

import com.jesusn.booking.inventory_service.dtos.request.PhysicalSeatRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.PhysicalSeatResponseDTO;
import com.jesusn.booking.inventory_service.entities.PhysicalSeat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface PhysicalSeatMapper {

    @Mapping(source = "zone.id", target = "zoneId")
    PhysicalSeatResponseDTO toDto(PhysicalSeat entity);

    List<PhysicalSeatResponseDTO> toDtoList(List<PhysicalSeat> entities);


    PhysicalSeat toEntity(PhysicalSeatRequestDTO dto);


}
