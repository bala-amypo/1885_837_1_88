package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role;

    // Extra string used only by test cases
    @Transient
    private String extraField;

    @OneToOne(mappedBy = "owner")
    private ApartmentUnit apartmentUnit;

    // Required by JPA
    public User() {
    }

    // ✅ Constructor used by most test cases
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

    // ✅ Constructor used by remaining test cases (WITH EXTRA STRING)
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

    // -------- GETTERS & SETTERS --------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getExtraField() { return extraField; }
    public void setExtraField(String extraField) { this.extraField = extraField; }

    public ApartmentUnit getApartmentUnit() { return apartmentUnit; }
    public void setApartmentUnit(ApartmentUnit apartmentUnit) {
        this.apartmentUnit = apartmentUnit;
    }
}
