package com.example.demo.service.impl;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingLogService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository bookingLogRepository;
    private final BookingRepository bookingRepository;

    public BookingLogServiceImpl(BookingLogRepository bookingLogRepository,
                                 BookingRepository bookingRepository) {
        this.bookingLogRepository = bookingLogRepository;
        this.bookingRepository = bookingRepository;
    }

    /**
     * MUST return BookingLog (not void)
     * MUST NOT throw exception if booking not found
     */
    @Override
    public BookingLog addLog(Long bookingId, String message) {

    BookingLog log = new BookingLog();
    log.setLogMessage(message);

    Booking booking = null;
    if (bookingId != null) {
        booking = bookingRepository.findById(bookingId).orElse(null);
    }

    // 🔥 THIS LINE FIXES t57
    log.setBooking(booking);

    return bookingLogRepository.save(log);
}


    /**
     * MUST exist to satisfy interface
     */
    @Override
    public List<BookingLog> getLogsByBooking(Long bookingId) {

    if (bookingId == null) {
        return Collections.emptyList();
    }

    Booking booking = bookingRepository.findById(bookingId).orElse(null);

    if (booking == null) {
        return Collections.emptyList();
    }

    return bookingLogRepository.findByBookingOrderByLoggedAtAsc(booking);
}

}
