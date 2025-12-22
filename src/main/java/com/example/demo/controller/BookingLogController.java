package com.example.demo.controller;

import com.example.demo.model.BookingLog;
import com.example.demo.service.BookingLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/booking-logs")
@RequiredArgsConstructor
public class BookingLogController {

    private final BookingLogService logService;

    @PostMapping
    public BookingLog addLog(@RequestBody BookingLog log) {
        return logService.saveLog(log);
    }

    @GetMapping
    public List<BookingLog> getAllLogs() {
        return logService.getAllLogs();
    }
}
