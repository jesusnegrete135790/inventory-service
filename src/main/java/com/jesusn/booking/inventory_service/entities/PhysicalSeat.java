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

    @OneToMany
    @JoinColumn(name ="zone_id" ,referencedColumnName = "id",nullable = true)
    private Integer zoneId;

    public PhysicalSeat() {
    }

    public PhysicalSeat(Integer id, Integer seatNumber, String rowLetter, Integer zoneId) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.rowLetter = rowLetter;
        this.zoneId = zoneId;
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

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }
}
