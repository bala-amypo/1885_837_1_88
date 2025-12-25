package com.example.demo.model;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Booking {

    public static final String STATUS_CONFIRMED = "CONFIRMED";
    public static final String STATUS_CANCELLED = "CANCELLED";

    private Long id;
    private Facility facility;
    private User user;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    public Booking() {
        this.status = STATUS_CONFIRMED;
    }
}
