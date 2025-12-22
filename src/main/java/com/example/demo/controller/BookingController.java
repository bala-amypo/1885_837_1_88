package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@Tag(name = "Booking", description = "Create, cancel, and view bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // POST /bookings/{facilityId}/{userId}
    @PostMapping("/{facilityId}/{userId}")
    public ResponseEntity<?> createBooking(@PathVariable Long facilityId,
                                           @PathVariable Long userId,
                                           @RequestBody Booking booking) {
        Booking saved = bookingService.createBooking(facilityId, userId, booking);
        return ResponseEntity.ok(saved);
    }

    // PUT /bookings/cancel/{bookingId}
    @PutMapping("/cancel/{bookingId}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long bookingId) {
        Booking updated = bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok(updated);
    }

    // GET /bookings/{bookingId}
    @GetMapping("/{bookingId}")
    public ResponseEntity<?> getBooking(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBooking(bookingId);
        return ResponseEntity.ok(booking);
    }
}
