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

    @Transient
    private String extra1;

    @Transient
    private String extra2;

    @OneToOne(mappedBy = "owner")
    private ApartmentUnit apartmentUnit;

    // ===== REQUIRED BY JPA =====
    public User() {}

    // ===== USED BY TEST (5 STRINGS) =====
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

    // ===== USED BY TEST (6 STRINGS) =====
    public User(Long id,
                String name,
                String email,
                String password,
                String role,
                String extra1,
                ApartmentUnit apartmentUnit) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.extra1 = extra1;
        this.apartmentUnit = apartmentUnit;
    }

    // ===== USED BY TEST (7 STRINGS) =====
    public User(Long id,
                String name,
                String email,
                String password,
                String role,
                String extra1,
                String extra2,
                ApartmentUnit apartmentUnit) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.extra1 = extra1;
        this.extra2 = extra2;
        this.apartmentUnit = apartmentUnit;
    }

    // ===== GETTERS / SETTERS =====

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
