package com.jesusn.booking.inventory_service.mappers;

import com.jesusn.booking.inventory_service.dtos.request.ZoneRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.ZoneResponseDTO;
import com.jesusn.booking.inventory_service.entities.Zone;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ZoneMapper {


    ZoneResponseDTO toDto(Zone entity);

    List<ZoneResponseDTO>toDtoList(List<Zone> entities);


    Zone toEntity(ZoneRequestDTO dto);

}
