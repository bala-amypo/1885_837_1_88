package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.demo.model.*;

import java.util.List;

public interface BookingLogRepository extends JpaRepository<BookingLog, Long> {
    List<BookingLog> findByBookingOrderByLoggedAtAsc(Booking booking);
}
