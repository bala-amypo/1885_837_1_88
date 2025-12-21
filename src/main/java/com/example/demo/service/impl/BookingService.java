package com.example.demo.service.impl;

import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FacilityRepository facilityRepository;
    private final UserRepository userRepository;
    private final BookingLogService bookingLogService;

    // ⚠️ constructor order STRICT
    public BookingService(BookingRepository bookingRepository,
                          FacilityRepository facilityRepository,
                          UserRepository userRepository,
                          BookingLogService bookingLogService) {
        this.bookingRepository = bookingRepository;
        this.facilityRepository = facilityRepository;
        this.userRepository = userRepository;
        this.bookingLogService = bookingLogService;
    }

    public Booking createBooking(Long facilityId, Long userId, Booking booking) {
        Facility facility = facilityRepository.findById(facilityId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        booking.setFacility(facility);
        booking.setUser(user);
        booking.setStatus("CONFIRMED");

        Booking saved = bookingRepository.save(booking);
        bookingLogService.addLog(saved.getId(), "Booking created");
        return saved;
    }

    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        booking.setStatus("CANCELLED");
        Booking saved = bookingRepository.save(booking);
        bookingLogService.addLog(saved.getId(), "Booking cancelled");
        return saved;
    }

    public Booking getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }
}
