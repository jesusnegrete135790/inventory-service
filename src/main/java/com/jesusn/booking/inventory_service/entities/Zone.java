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

    @ManyToOne
    @JoinColumn(name ="venue_id" ,referencedColumnName = "id",nullable = true)
    private Venue venue;

    public Zone() {
    }

    public Zone(Integer id, Integer capacity, String name, Venue venue) {
        this.id = id;
        this.capacity = capacity;
        this.name = name;
        this.venue = venue;
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

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
