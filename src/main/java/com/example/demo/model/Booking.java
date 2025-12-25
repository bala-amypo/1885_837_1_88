package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Booking {

    public static final String STATUS_CONFIRMED="CONFIRMED";
    public static final String STATUS_CANCELLED="CANCELLED";

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Facility facility;

    @ManyToOne
    private User user;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String status = STATUS_CONFIRMED;

    public Booking(){}

    public Booking(Long id,Facility f,User u,
        LocalDateTime s,LocalDateTime e,String status){
        this.id=id; this.facility=f;
        this.user=u; this.startTime=s;
        this.endTime=e; this.status=status;
    }

    // getters & setters
}
