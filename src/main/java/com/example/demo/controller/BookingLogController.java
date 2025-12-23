package com.example.demo.controller;

import com.example.demo.model.BookingLog;
import com.example.demo.service.BookingLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking-logs")
public class BookingLogController {

    @Autowired
    private BookingLogService bookingLogService;

    @GetMapping("/{bookingId}")
    public List<BookingLog> getLogsByBooking(@PathVariable Long bookingId) {
        return bookingLogService.getLogsByBooking(bookingId);
    }
}
