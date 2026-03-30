package com.jesusn.booking.inventory_service.repositories;

import com.jesusn.booking.inventory_service.entities.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue,Integer> {
}
