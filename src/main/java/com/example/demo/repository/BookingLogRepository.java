package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.BookingLog;
import com.example.demo.model.Booking;

import java.util.List;

public interface BookingLogRepository extends JpaRepository<BookingLog, Long> {
    List<BookingLog> findByBookingOrderByLoggedAtAsc(Booking booking);
}
