package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    // Default role: RESIDENT
    @Builder.Default
    @Column(nullable = false)
    private String role = "RESIDENT";

    // One-to-one relationship with ApartmentUnit (inverse side)
    @OneToOne(mappedBy = "owner")
    private ApartmentUnit apartmentUnit;
}
