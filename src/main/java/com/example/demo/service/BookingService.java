package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import java.util.List;

public interface BookingService {
    Booking createBooking(Long userId, Long facilityId, Booking booking);
    Booking getBooking(Long id);
    void cancelBooking(Long id);
    List<Booking> getBookingsByFacility(Facility facility);
}
