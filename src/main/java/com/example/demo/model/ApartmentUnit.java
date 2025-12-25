package com.example.demo.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ApartmentUnit {

    private Long id;
    private String unitNumber;
    private int floor;
    private User owner;
}
