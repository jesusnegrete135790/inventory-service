package com.jesusn.booking.inventory_service.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "venues")
public class Venue {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String city;
    private String address;

    private LocalDateTime createdAt;

    public Venue() {
    }

    public Venue(Integer id, String name, String city, String address, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
