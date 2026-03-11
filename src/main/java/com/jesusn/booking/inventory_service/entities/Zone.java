package com.jesusn.booking.inventory_service.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "zones")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer capacity;
    private String name;

    @OneToMany
    @JoinColumn(name ="venue_id" ,referencedColumnName = "id",nullable = true)
    private Integer venueId;

    public Zone() {
    }

    public Zone(Integer id, Integer capacity, String name, Integer venueId) {
        this.id = id;
        this.capacity = capacity;
        this.name = name;
        this.venueId = venueId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }
}
