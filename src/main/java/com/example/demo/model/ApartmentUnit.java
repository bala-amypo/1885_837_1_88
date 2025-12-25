package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ApartmentUnit {

    @Id
    @GeneratedValue
    private Long id;

    private String unitNumber;
    private int floor;

    @OneToOne
    private User owner;

    public ApartmentUnit(){}

    public ApartmentUnit(Long id,String unitNumber,int floor,User owner){
        this.id=id; this.unitNumber=unitNumber;
        this.floor=floor; this.owner=owner;
    }

    // getters & setters
}
