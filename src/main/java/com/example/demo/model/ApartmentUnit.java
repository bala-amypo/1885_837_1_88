package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitNumber;

    @ManyToOne
    private User user;

    // Getters & Setters
    public Long getId() { return id; }
    public String getUnitNumber() { return unitNumber; }
    public void setUnitNumber(String unitNumber) { this.unitNumber = unitNumber; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
