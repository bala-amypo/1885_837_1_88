package com.example.demo.service.impl;

import com.example.demo.model.BookingLog;
import com.example.demo.model.Booking;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingLogService;
import com.example.demo.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service  // <- this tells Spring to create a bean
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository logRepository;
    private final BookingRepository bookingRepository;

    public BookingLogServiceImpl(BookingLogRepository logRepository,
                                 BookingRepository bookingRepository) {
        this.logRepository = logRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingLog addLog(Long bookingId, String message) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BadRequestException("Booking not found"));
        BookingLog log = BookingLog.builder()
                .booking(booking)
                .logMessage(message)
                .loggedAt(LocalDateTime.now())
                .build();
        return logRepository.save(log);
    }

    @Override
    public List<BookingLog> getLogsByBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BadRequestException("Booking not found"));
        return logRepository.findByBookingOrderByLoggedAtAsc(booking);
    }
}
