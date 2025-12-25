package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.model.*;
import com.example.demo.exception.*;
import com.example.demo.service.*;

import java.util.List;

public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository repo;

    public FacilityServiceImpl(FacilityRepository r) {
        this.repo = r;
    }

    public Facility addFacility(Facility f) {
        if (repo.findByName(f.getName()).isPresent())
            throw new BadRequestException("Exists");

        if (f.getOpenTime().compareTo(f.getCloseTime()) >= 0)
            throw new BadRequestException("Invalid time");

        return repo.save(f);
    }

    public List<Facility> getAllFacilities() {
        return repo.findAll();
    }
}
