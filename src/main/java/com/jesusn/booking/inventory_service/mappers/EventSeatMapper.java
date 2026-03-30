package com.jesusn.booking.inventory_service.mappers;

import com.jesusn.booking.inventory_service.dtos.request.EventSeatRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.EventSeatResponseDTO;
import com.jesusn.booking.inventory_service.entities.EventSeat;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface EventSeatMapper {


    EventSeatResponseDTO toDto(EventSeat entity);

    List<EventSeatResponseDTO> toDtoList(List<EventSeat> entities);


    EventSeat toEntity(EventSeatRequestDTO dto);


}
