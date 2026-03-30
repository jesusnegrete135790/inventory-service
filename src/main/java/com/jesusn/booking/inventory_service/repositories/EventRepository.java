package com.jesusn.booking.inventory_service.repositories;

import com.jesusn.booking.inventory_service.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
}
