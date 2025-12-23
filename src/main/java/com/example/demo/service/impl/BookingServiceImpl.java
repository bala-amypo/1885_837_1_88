package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public Booking createBooking(Long userId, Long facilityId, Booking booking) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Facility facility = facilityRepository.findById(facilityId)
                .orElseThrow(() -> new RuntimeException("Facility not found"));
        booking.setUser(user);
        booking.setFacility(facility);
        booking.setStatus("CREATED");
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBooking(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public void cancelBooking(Long id) {
        Booking booking = getBooking(id);
        booking.setStatus("CANCELLED");
        bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByFacility(Facility facility) {
        return bookingRepository.findAll().stream()
                .filter(b -> b.getFacility().getId().equals(facility.getId()))
                .toList();
    }
}
