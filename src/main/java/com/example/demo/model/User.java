package com.example.demo.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;

    private ApartmentUnit apartmentUnit;
}
