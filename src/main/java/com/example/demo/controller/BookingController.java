package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import com.example.demo.service.BookingService;
import com.example.demo.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final FacilityService facilityService;

    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {
        // Optionally validate facility exists
        Facility facility = facilityService.getFacilityById(booking.getFacility().getId());
        booking.setFacility(facility);
        return bookingService.saveBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("/facility/{facilityId}")
    public List<Booking> getBookingsByFacility(@PathVariable Long facilityId) {
        Facility facility = facilityService.getFacilityById(facilityId);
        return bookingService.getBookingsByFacility(facility);
    }
}
