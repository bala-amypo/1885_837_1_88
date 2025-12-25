package com.example.demo.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Facility {

    private Long id;
    private String name;
    private String description;
    private String openTime;
    private String closeTime;
}
