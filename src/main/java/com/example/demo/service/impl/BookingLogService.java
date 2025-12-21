package com.example.demo.service.impl;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingLogService {

    private final BookingLogRepository bookingLogRepository;
    private final BookingRepository bookingRepository;

    public BookingLogService(BookingLogRepository bookingLogRepository,
                             BookingRepository bookingRepository) {
        this.bookingLogRepository = bookingLogRepository;
        this.bookingRepository = bookingRepository;
    }

    public BookingLog addLog(Long bookingId, String message) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        BookingLog log = new BookingLog();
        log.setBooking(booking);
        log.setLogMessage(message);
        return bookingLogRepository.save(log);
    }

    public List<BookingLog> getLogsByBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        return bookingLogRepository.findByBookingOrderByLoggedAtAsc(booking);
    }
}
