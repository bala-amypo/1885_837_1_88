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

    @Transient
    private String extra3;

    @OneToOne(mappedBy = "owner")
    private ApartmentUnit apartmentUnit;

    // JPA requirement
    public User() {}

    // 5 strings
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

    // 6 strings
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

    // 7 strings
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

    // 🔥 8-ARG CONSTRUCTOR (THIS WAS MISSING)
    public User(Long id,
                String name,
                String email,
                String password,
                String role,
                String extra1,
                String extra2,
                String extra3,
                ApartmentUnit apartmentUnit) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.extra1 = extra1;
        this.extra2 = extra2;
        this.extra3 = extra3;
        this.apartmentUnit = apartmentUnit;
    }

    // getters & setters omitted for brevity (keep yours)
}
