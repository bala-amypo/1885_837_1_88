package com.example.demo.serviceimpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingLogService;
import java.time.LocalDateTime;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    @Autowired
    private BookingLogRepository bookingLogRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void addLog(Long bookingId, String action) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        BookingLog log = new BookingLog(booking, action, LocalDateTime.now());
        bookingLogRepository.save(log);
    }

    @Override
    public List<BookingLog> getLogsByBooking(Long bookingId) {
        return bookingLogRepository.findAllByBookingId(bookingId);
    }
}
