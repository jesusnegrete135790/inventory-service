package com.jesusn.booking.inventory_service.mappers;

import com.jesusn.booking.inventory_service.dtos.request.VenueRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.VenueResponseDTO;
import com.jesusn.booking.inventory_service.entities.Venue;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VenueMapper {

    VenueResponseDTO toDto(Venue entity);

    List<VenueResponseDTO> toDtoList(List<Venue> entities);

    Venue toEntity(VenueRequestDTO dto);

}
