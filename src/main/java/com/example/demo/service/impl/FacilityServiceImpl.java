package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;

    @Override
    public Facility addFacility(Facility facility) {
        if (facilityRepository.findByName(facility.getName()).isPresent()) {
            throw new BadRequestException("Facility name duplicate");
        }

        try {
            LocalTime open = LocalTime.parse(facility.getOpenTime());
            LocalTime close = LocalTime.parse(facility.getCloseTime());
            if (!open.isBefore(close)) {
                throw new BadRequestException("Open time must be less than close time");
            }
        } catch (DateTimeParseException e) {
            throw new BadRequestException("Invalid time format");
        }

        return facilityRepository.save(facility);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility getFacilityById(Long id) {
        return facilityRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Facility not found"));
    }
}
