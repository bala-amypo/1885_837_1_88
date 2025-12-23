// package com.example.demo.service.impl;

// import com.example.demo.model.Booking;
// import com.example.demo.model.BookingLog;
// import com.example.demo.repository.BookingLogRepository;
// import com.example.demo.repository.BookingRepository;
// import com.example.demo.service.BookingLogService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class BookingLogServiceImpl implements BookingLogService {

//     @Autowired
//     private BookingLogRepository bookingLogRepository;
//     @Autowired
//     private BookingRepository bookingRepository;

//     @Override
//     public void addLog(Long bookingId, String message) {
//         Booking booking = bookingRepository.findById(bookingId)
//                 .orElseThrow(() -> new RuntimeException("Booking not found"));
//         BookingLog log = new BookingLog();
//         log.setBooking(booking);
//         log.setLogMessage(message);
//         log.setLoggedAt(LocalDateTime.now());
//         bookingLogRepository.save(log);
//     }

//     @Override
//     public List<BookingLog> getLogsByBooking(Long bookingId) {
//         return bookingLogRepository.findByBookingId(bookingId);
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.service.BookingLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository bookingLogRepository;

    public BookingLogServiceImpl(BookingLogRepository bookingLogRepository) {
        this.bookingLogRepository = bookingLogRepository;
    }

    @Override
    public List<BookingLog> getLogsByBooking(Long bookingId) {
        // fixed: use repository method that exists
        return bookingLogRepository.findByBookingId(bookingId);
    }

    @Override
    public void addLog(Long bookingId, String message) {
        BookingLog log = new BookingLog();
        log.setBookingId(bookingId);
        log.setLogMessage(message);
        log.setLoggedAt(java.time.LocalDateTime.now());
        bookingLogRepository.save(log);
    }
}
