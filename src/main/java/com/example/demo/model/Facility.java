package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Facility {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private String openTime;
    private String closeTime;

    public Facility(){}

    public Facility(Long id,String name,String desc,String open,String close){
        this.id=id; this.name=name;
        this.description=desc;
        this.openTime=open; this.closeTime=close;
    }

    // getters & setters
}
