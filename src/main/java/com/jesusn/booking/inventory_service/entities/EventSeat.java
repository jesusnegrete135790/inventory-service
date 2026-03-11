package com.jesusn.booking.inventory_service.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "event_seats")
public class EventSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer version; //BLOQUEO OPTIMISTA PARA CONCURRENCIA

    private BigDecimal price;

    private String status;

    @OneToOne
    @JoinColumn(name ="event_id" ,referencedColumnName = "id",nullable = true)
    private Integer eventId;

    @OneToOne
    @JoinColumn(name ="physical_seat_id" ,referencedColumnName = "id",nullable = true)
    private Integer physicalSeatId;

    public EventSeat() {
    }

    public EventSeat(Integer id, Integer version, BigDecimal price, String status, Integer eventId, Integer physicalSeatId) {
        this.id = id;
        this.version = version;
        this.price = price;
        this.status = status;
        this.eventId = eventId;
        this.physicalSeatId = physicalSeatId;
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

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getPhysicalSeatId() {
        return physicalSeatId;
    }

    public void setPhysicalSeatId(Integer physicalSeatId) {
        this.physicalSeatId = physicalSeatId;
    }
}
