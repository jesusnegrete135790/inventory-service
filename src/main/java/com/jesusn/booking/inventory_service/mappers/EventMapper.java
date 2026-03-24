package com.jesusn.booking.inventory_service.mappers;

import com.jesusn.booking.inventory_service.dtos.request.EventRequestDTO;
import com.jesusn.booking.inventory_service.dtos.response.EventResponseDTO;
import com.jesusn.booking.inventory_service.entities.Event;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventResponseDTO toDto(Event entity);

    List<EventResponseDTO> toDtoList(List<Event> entities);

    Event toEntity(EventRequestDTO dto);

}
