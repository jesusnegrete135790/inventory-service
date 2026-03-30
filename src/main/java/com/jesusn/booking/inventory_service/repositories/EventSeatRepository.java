package com.jesusn.booking.inventory_service.repositories;

import com.jesusn.booking.inventory_service.entities.EventSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventSeatRepository extends JpaRepository<EventSeat,Integer> {
}
