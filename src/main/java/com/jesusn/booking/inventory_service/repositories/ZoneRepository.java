package com.jesusn.booking.inventory_service.repositories;

import com.jesusn.booking.inventory_service.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {
}
