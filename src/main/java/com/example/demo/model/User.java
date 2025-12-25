package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role;

    @OneToOne(mappedBy = "owner")
    private ApartmentUnit apartmentUnit;

    public User() {}

    public User(Long id,String name,String email,String password,String role){
        this.id=id; this.name=name; this.email=email;
        this.password=password; this.role=role;
    }

    // getters & setters
}
