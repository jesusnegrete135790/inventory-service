package com.jesusn.booking.inventory_service.repositories;

import com.jesusn.booking.inventory_service.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Integer> {
}
