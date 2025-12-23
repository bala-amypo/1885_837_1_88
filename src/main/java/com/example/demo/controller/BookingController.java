package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/{userId}/{facilityId}")
    public Booking createBooking(@PathVariable Long userId,
                                 @PathVariable Long facilityId,
                                 @RequestBody Booking booking) {
        return bookingService.createBooking(userId, facilityId, booking);
    }

    @PostMapping("/cancel/{id}")
    public void cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return bookingService.getBooking(id);
    }
}
