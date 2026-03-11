package com.jesusn.booking.inventory_service.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String status; // DEFAULT 'SCHEDULED'     SCHEDULED, CANCELLED, FINISHED

    private LocalDateTime eventDate;
    private LocalDateTime createdAt;


    @OneToMany
    @JoinColumn(name ="venue_id" ,referencedColumnName = "id",nullable = true)
    private Integer venueId;

    public Event() {
    }

    public Event(Integer id, String title, String status, LocalDateTime eventDate, LocalDateTime createdAt, Integer venueId) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.eventDate = eventDate;
        this.createdAt = createdAt;
        this.venueId = venueId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }
}
