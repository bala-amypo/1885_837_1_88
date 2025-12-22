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

    public FacilityServiceImpl(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public Facility addFacility(Facility facility) {
        // Validate unique name
        if (facilityRepository.findByName(facility.getName()).isPresent()) {
            throw new BadRequestException("Facility name duplicate");
        }

        // Validate time format HH:mm
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            LocalTime open = LocalTime.parse(facility.getOpenTime(), formatter);
            LocalTime close = LocalTime.parse(facility.getCloseTime(), formatter);

            if (!open.isBefore(close)) {
                throw new BadRequestException("Open/close time invalid: time");
            }
        } catch (DateTimeParseException e) {
            throw new BadRequestException("Invalid time format: time");
        }

        return facilityRepository.save(facility);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }
}
