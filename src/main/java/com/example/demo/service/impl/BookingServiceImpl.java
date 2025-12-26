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
    private final BookingLogService bookingLogService;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              FacilityRepository facilityRepository,
                              UserRepository userRepository,
                              BookingLogService bookingLogService) {
        this.bookingRepository = bookingRepository;
        this.facilityRepository = facilityRepository;
        this.userRepository = userRepository;
        this.bookingLogService = bookingLogService;
    }

    @Override
    public Booking createBooking(Long facilityId, Long userId, Booking booking) {

        Facility facility = facilityRepository.findById(facilityId)
                .orElseThrow(() -> new BadRequestException("Facility not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));

        if (!booking.getStartTime().isBefore(booking.getEndTime())) {
            throw new BadRequestException("Invalid time");
        }

        List<Booking> conflicts =
                bookingRepository.findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
                        facility, booking.getEndTime(), booking.getStartTime());

        if (!conflicts.isEmpty()) {
            throw new ConflictException("Booking conflict detected");
        }

        booking.setFacility(facility);
        booking.setUser(user);
        booking.setStatus(Booking.STATUS_CONFIRMED);

        Booking saved = bookingRepository.save(booking);
        bookingLogService.addLog(saved.getId(), "Created");

        return saved;
    }

    @Override
    public Booking cancelBooking(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BadRequestException("Booking not found"));

        booking.setStatus(Booking.STATUS_CANCELLED);
        Booking updated = bookingRepository.save(booking);

        bookingLogService.addLog(updated.getId(), "Cancelled");

        return updated;
    }

    @Override
    public Booking getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BadRequestException("Booking not found"));
    }

    @Override
public Booking getBooking(Long bookingId) {
    return bookingRepository.findById(bookingId)
            .orElseThrow(() -> new BadRequestException("Booking not found"));
}




}
