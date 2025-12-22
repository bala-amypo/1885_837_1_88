package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "apartment_units")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitNumber;
    private int floor;

    @ManyToOne
    private User owner;
}
