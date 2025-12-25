package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Add this custom method if needed
    List<Booking> findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(Facility facility, LocalDateTime endTime, LocalDateTime startTime);
}
