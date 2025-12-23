package com.example.demo.service;

import com.example.demo.model.Facility;
import java.util.List;

public interface FacilityService {
    Facility addFacility(Facility facility); // <- Make sure this exists
    List<Facility> getAllFacilities();
}
