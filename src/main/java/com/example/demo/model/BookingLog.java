package com.example.demo.model;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BookingLog {

    private Long id;
    private Booking booking;
    private String logMessage;
    private LocalDateTime loggedAt;

    public void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }
}
