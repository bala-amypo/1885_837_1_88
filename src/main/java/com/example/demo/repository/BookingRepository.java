package com.example.demo.repository;

import com.example.demo.model.Booking;
import com.example.demo.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // ✅ Add this to fix findByFacility error
    List<Booking> findByFacility(Facility facility);
}
