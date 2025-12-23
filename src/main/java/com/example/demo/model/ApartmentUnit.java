package com.example.demo.model;

public class ApartmentUnit {
    private Long id;
    private int floor;
    private int unitNumber;
    private User owner;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getFloor() { return floor; }
    public void setFloor(int floor) { this.floor = floor; }

    public int getUnitNumber() { return unitNumber; }
    public void setUnitNumber(int unitNumber) { this.unitNumber = unitNumber; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
}
