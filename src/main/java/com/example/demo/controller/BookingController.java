package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Operation(summary = "Create a booking")
    @PostMapping("/user/{userId}/facility/{facilityId}")
    public Booking createBooking(
            @PathVariable Long userId,
            @PathVariable Long facilityId,
            @RequestBody Booking booking) {

        return bookingService.createBooking(userId, facilityId, booking);
    }

    @Operation(summary = "Cancel a booking")
    @PutMapping("/{bookingId}/cancel")
    public Booking cancelBooking(@PathVariable Long bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

    @Operation(summary = "Get booking by ID")
    @GetMapping("/{bookingId}")
    public Booking getBooking(@PathVariable Long bookingId) {
        return bookingService.getBooking(bookingId);
    }
}
