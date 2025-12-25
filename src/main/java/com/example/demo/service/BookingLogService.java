package com.example.demo.service;

import java.util.List;
import com.example.demo.model.BookingLog;

public interface BookingLogService {
    void addLog(Long bookingId, String action);
    List<BookingLog> getLogsByBooking(Long bookingId);
}

public interface ApartmentUnitService {
    ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit);
    ApartmentUnit getUnitByUser(Long userId);
}
