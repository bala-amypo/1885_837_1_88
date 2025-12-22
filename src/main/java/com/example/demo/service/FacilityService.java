package com.example.demo.service;

import com.example.demo.model.Facility;
import java.util.List;

public interface FacilityService {
    Facility saveFacility(Facility facility);
    List<Facility> getAllFacilities();
    Facility getFacilityById(Long id);
}
