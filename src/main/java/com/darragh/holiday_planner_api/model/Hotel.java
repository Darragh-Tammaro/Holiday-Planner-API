package com.darragh.holiday_planner_api.model;
import jakarta.persistence.*;

@Entity
@Table(name = "hotels")


public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double pricePerNight;
    private int numberOfRooms;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "holiday_id")
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("hotels")
    private Holiday holiday;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Holiday getHoliday() {
        return holiday;
    }
    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }
}
