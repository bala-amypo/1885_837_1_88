package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.model.*;
import com.example.demo.exception.*;
import com.example.demo.service.*;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final FacilityRepository facilityRepo;
    private final UserRepository userRepo;
    private final BookingLogService logService;

    public BookingServiceImpl(BookingRepository b, FacilityRepository f,
                              UserRepository u, BookingLogService l) {
        this.bookingRepo = b;
        this.facilityRepo = f;
        this.userRepo = u;
        this.logService = l;
    }

    public Booking createBooking(Long facilityId, Long userId, Booking booking) {
        Facility fac = facilityRepo.findById(facilityId).orElseThrow();
        User user = userRepo.findById(userId).orElseThrow();

        List<Booking> conflicts =
                bookingRepo.findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
                        fac, booking.getEndTime(), booking.getStartTime());

        if (!conflicts.isEmpty())
            throw new ConflictException("Conflict");

        booking.setFacility(fac);
        booking.setUser(user);
        booking.setStatus(Booking.STATUS_CONFIRMED);

        Booking saved = bookingRepo.save(booking);
        logService.addLog(saved.getId(), "Created");
        return saved;
    }

    public Booking cancelBooking(Long bookingId) {
        Booking b = bookingRepo.findById(bookingId).orElseThrow();
        b.setStatus(Booking.STATUS_CANCELLED);
        Booking saved = bookingRepo.save(b);
        logService.addLog(saved.getId(), "Cancelled");
        return saved;
    }

    public Booking getBooking(Long id) {
        return bookingRepo.findById(id).orElse(null);
    }
}
