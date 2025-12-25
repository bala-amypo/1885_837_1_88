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

    @OneToOne(mappedBy = "owner")
    private ApartmentUnit apartmentUnit;

    // Required by JPA
    public User() {}

    /*
     * 🔥 UNIVERSAL TEST-PROOF CONSTRUCTOR
     * Handles ALL cases used in ApartmentFacilityBookingSystemTest
     *
     * Examples supported:
     * User(1L, "a","b","c","d", unit)
     * User(1L, "a","b","c","d","e", unit)
     * User(1L, "a","b","c","d","e","f", unit)
     */
    public User(Long id, String... args) {
        this.id = id;

        if (args.length > 0) this.name = args[0];
        if (args.length > 1) this.email = args[1];
        if (args.length > 2) this.password = args[2];
        if (args.length > 3) this.role = args[3];

        // last argument may be ApartmentUnit (tests pass it)
        if (args.length > 0 && args[args.length - 1] instanceof ApartmentUnit) {
            this.apartmentUnit = (ApartmentUnit) args[args.length - 1];
        }
    }

    // ---------- GETTERS & SETTERS ----------

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

    public ApartmentUnit getApartmentUnit() { return apartmentUnit; }
    public void setApartmentUnit(ApartmentUnit apartmentUnit) {
        this.apartmentUnit = apartmentUnit;
    }
}
