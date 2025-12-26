package com.example.demo.repository;

import com.example.demo.model.BookingLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingLogRepository extends JpaRepository<BookingLog, Long> {

    // 🔥 ADD THIS METHOD
    List<BookingLog> findByBookingId(Long bookingId);
}
