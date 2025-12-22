package com.example.demo.service.impl;

import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.service.BookingLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository logRepository;

    @Override
    public BookingLog saveLog(BookingLog log) {
        return logRepository.save(log);
    }

    @Override
    public List<BookingLog> getAllLogs() {
        return logRepository.findAll();
    }
}
