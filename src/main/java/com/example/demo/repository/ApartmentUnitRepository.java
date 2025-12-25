package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;
import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.model.ApartmentUnit;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {}
public interface BookingRepository extends JpaRepository<Booking, Long> {}
public interface BookingLogRepository extends JpaRepository<BookingLog, Long> {
    List<BookingLog> findAllByBookingId(Long bookingId);
}
public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {
    ApartmentUnit findByUserId(Long userId);
}
