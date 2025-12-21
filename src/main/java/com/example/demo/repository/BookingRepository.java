package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Booking;
import com.example.demo.model.Facility;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
            Facility facility,
            LocalDateTime start,
            LocalDateTime end
    );
}
