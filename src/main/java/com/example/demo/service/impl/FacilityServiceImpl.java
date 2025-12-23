package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;

    // Constructor injection (order matters)
    public FacilityServiceImpl(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public Facility addFacility(Facility facility) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime open = LocalTime.parse(facility.getOpenTime(), formatter);
            LocalTime close = LocalTime.parse(facility.getCloseTime(), formatter);

            if (!open.isBefore(close)) {
                throw new BadRequestException("Invalid time range");
            }
        } catch (DateTimeParseException ex) {
            throw new BadRequestException("Invalid time format");
        }

        return facilityRepository.save(facility);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }
}
