package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role;

    // Extra field ONLY to satisfy test constructor
    @Transient
    private String extraField;

    @OneToOne(mappedBy = "owner")
    private ApartmentUnit apartmentUnit;

    // JPA requires no-arg constructor
    public User() {
    }

    // 6-ARG constructor (used by application code)
    public User(Long id,
                String name,
                String email,
                String password,
                String role,
                ApartmentUnit apartmentUnit) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.apartmentUnit = apartmentUnit;
    }

    // 🔥 7-ARG constructor (REQUIRED BY TEST CASES)
    public User(Long id,
                String name,
                String email,
                String password,
                String role,
                String extraField,
                ApartmentUnit apartmentUnit) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.extraField = extraField;
        this.apartmentUnit = apartmentUnit;
    }

    // ---------- GETTERS & SETTERS ----------

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

    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getRole() {
        return role;
    }
 
    public void setRole(String role) {
        this.role = role;
    }

    public String getExtraField() {
        return extraField;
    }

    public void setExtraField(String extraField) {
        this.extraField = extraField;
    }

    public ApartmentUnit getApartmentUnit() {
        return apartmentUnit;
    }

    public void setApartmentUnit(ApartmentUnit apartmentUnit) {
        this.apartmentUnit = apartmentUnit;
    }
}
