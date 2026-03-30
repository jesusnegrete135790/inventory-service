package com.jesusn.booking.inventory_service.repositories;

import com.jesusn.booking.inventory_service.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {
}
