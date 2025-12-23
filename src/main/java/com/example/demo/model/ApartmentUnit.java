package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ApartmentUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int floor;
    private String unitNumber;

    @ManyToOne
    private User owner;

    // Getters and Setters
    public Long getId() { return id; }
    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }
    public String getUnitNumber() { return unitNumber; }
    public void setUnitNumber(String unitNumber) { this.unitNumber = unitNumber; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
