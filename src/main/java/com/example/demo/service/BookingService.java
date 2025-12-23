package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.model.Facility;

import java.util.List;

public interface BookingService {
    Booking saveBooking(Booking booking); // ✅ Added
    Booking getBookingById(Long id);      // ✅ Added
    List<Booking> getAllBookings();
    List<Booking> getBookingsByFacility(Facility facility);
}
