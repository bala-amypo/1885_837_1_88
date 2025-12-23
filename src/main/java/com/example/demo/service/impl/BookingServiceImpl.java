package com.example.demo.service.impl;

import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // ✅ ADD THIS
    @Override
    public List<Booking> getBookingsByFacility(Facility facility) {
        return bookingRepository.findByFacility(facility);
    }
}
