package com.jesusn.booking.inventory_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_seats")
public class EventSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer version; //BLOQUEO OPTIMISTA PARA CONCURRENCIA

    private BigDecimal price;

    private String status;
    @Column(name = "locked_at")
    private LocalDateTime lockedAt;

    @ManyToOne
    @JoinColumn(name ="event_id" ,referencedColumnName = "id",nullable = true)
    private Event event;

    @ManyToOne
    @JoinColumn(name ="physical_seat_id" ,referencedColumnName = "id",nullable = true)
    private PhysicalSeat physicalSeat;

    public EventSeat() {
    }

    public EventSeat(Integer id, Integer version, BigDecimal price, String status, LocalDateTime lockedAt, Event event, PhysicalSeat physicalSeat) {
        this.id = id;
        this.version = version;
        this.price = price;
        this.status = status;
        this.lockedAt = lockedAt;
        this.event = event;
        this.physicalSeat = physicalSeat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getLockedAt() {
        return lockedAt;
    }

    public void setLockedAt(LocalDateTime lockedAt) {
        this.lockedAt = lockedAt;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public PhysicalSeat getPhysicalSeat() {
        return physicalSeat;
    }

    public void setPhysicalSeat(PhysicalSeat physicalSeat) {
        this.physicalSeat = physicalSeat;
    }
}
