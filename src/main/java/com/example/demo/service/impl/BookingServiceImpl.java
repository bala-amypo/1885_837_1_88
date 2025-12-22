package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ConflictException;
import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingLogService;
import com.example.demo.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final FacilityRepository facilityRepository;
    private final UserRepository userRepository;
    private final BookingLogService logService;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              FacilityRepository facilityRepository,
                              UserRepository userRepository,
                              BookingLogService logService) {
        this.bookingRepository = bookingRepository;
        this.facilityRepository = facilityRepository;
        this.userRepository = userRepository;
        this.logService = logService;
    }

    @Override
    public Booking createBooking(Long facilityId, Long userId, Booking booking) {
        Facility facility = facilityRepository.findById(facilityId)
                .orElseThrow(() -> new BadRequestException("Facility not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));

        // Validate time range
        if (!booking.getEndTime().isAfter(booking.getStartTime())) {
            throw new BadRequestException("End time must be after start time");
        }

        // Check for overlapping bookings
        List<Booking> conflicts = bookingRepository
                .findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
                        facility, booking.getEndTime(), booking.getStartTime());
        if (!conflicts.isEmpty()) {
            throw new ConflictException("Facility booking conflict detected: conflict");
        }

        // Set relationships and default status
        booking.setFacility(facility);
        booking.setUser(user);
        if (booking.getStatus() == null) booking.setStatus("CONFIRMED");

        Booking saved = bookingRepository.save(booking);

        // Log creation
        logService.addLog(saved.getId(), "Booking created");

        return saved;
    }

    @Override
    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BadRequestException("Booking not found"));
        booking.setStatus("CANCELLED");
        Booking saved = bookingRepository.save(booking);

        // Log cancellation
        logService.addLog(saved.getId(), "Booking cancelled");

        return saved;
    }

    @Override
    public Booking getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BadRequestException("Booking not found"));
    }
}
