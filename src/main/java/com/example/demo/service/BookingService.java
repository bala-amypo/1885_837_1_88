package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> getAllBookings();

    // ADD THIS:
    List<Booking> getBookingsByFacility(Facility facility);
}
