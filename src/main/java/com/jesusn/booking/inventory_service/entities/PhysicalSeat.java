package com.jesusn.booking.inventory_service.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "physical_seats")
public class PhysicalSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer seatNumber;
    private String rowLetter;

    @ManyToOne
    @JoinColumn(name ="zone_id" ,referencedColumnName = "id",nullable = true)
    private Zone zone;

    public PhysicalSeat() {
    }

    public PhysicalSeat(Integer id, Integer seatNumber, String rowLetter, Zone zone) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.rowLetter = rowLetter;
        this.zone = zone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getRowLetter() {
        return rowLetter;
    }

    public void setRowLetter(String rowLetter) {
        this.rowLetter = rowLetter;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}
