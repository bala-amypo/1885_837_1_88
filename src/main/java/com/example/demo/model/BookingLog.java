package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BookingLog {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Booking booking;

    private String logMessage;
    private LocalDateTime loggedAt;

    public BookingLog(){}

    public BookingLog(Long id,Booking b,String msg,LocalDateTime t){
        this.id=id; this.booking=b;
        this.logMessage=msg; this.loggedAt=t;
    }

    @PrePersist
    public void onCreate(){
        loggedAt=LocalDateTime.now();
    }

    // getters & setters
}
