package com.example.demo.repository;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingLogRepository extends JpaRepository<BookingLog, Long> {

    // already added earlier
    List<BookingLog> findByBookingId(Long bookingId);

    // 🔥 ADD THIS LINE (THIS FIXES THE LAST ERROR)
    List<BookingLog> findByBookingOrderByLoggedAtAsc(Booking booking);
}
