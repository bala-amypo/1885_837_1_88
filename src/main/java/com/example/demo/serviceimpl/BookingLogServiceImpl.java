package com.example.demo.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingLogService;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    @Autowired
    private BookingLogRepository bookingLogRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // Implement the addLog method from interface
    @Override
    public void addLog(Long bookingId, String action) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + bookingId));
        
        BookingLog log = new BookingLog(booking, action, LocalDateTime.now());
        bookingLogRepository.save(log);
    }

    // If you have a method to fetch logs by booking
    @Override
    public List<BookingLog> getLogsByBooking(Long bookingId) {
        return bookingLogRepository.findAllByBookingId(bookingId);
    }
}
