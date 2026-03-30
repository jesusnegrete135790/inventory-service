package com.jesusn.booking.inventory_service.repositories;

import com.jesusn.booking.inventory_service.entities.EventSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventSeatRepository extends JpaRepository<EventSeat, Integer> {
    List<EventSeat> findByEventId(Integer eventId);
}