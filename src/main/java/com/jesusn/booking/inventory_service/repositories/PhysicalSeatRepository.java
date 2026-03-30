package com.jesusn.booking.inventory_service.repositories;


import com.jesusn.booking.inventory_service.entities.PhysicalSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhysicalSeatRepository extends JpaRepository<PhysicalSeat,Integer> {
    List<PhysicalSeat> findByZoneId(Integer zoneId);
    List<PhysicalSeat> findByZoneVenueId(Integer venueId);
}
