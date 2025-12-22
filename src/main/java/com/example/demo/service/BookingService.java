package com.example.demo.service;

import com.example.demo.model.Booking;
import java.util.List;

public interface BookingService {
    Booking saveBooking(Booking booking);
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
}
