package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action; // CREATED, UPDATED, CANCELLED
    private LocalDateTime timestamp;

    @ManyToOne
    private Booking booking;

    @ManyToOne
    private User performedBy;
}
