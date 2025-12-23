package com.example.demo.controller;

import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @PostMapping
    public Facility addFacility(@RequestBody Facility facility) {
        return facilityService.saveFacility(facility);
    }

    @GetMapping
    public List<Facility> getAllFacilities() {
        return facilityService.getAllFacilities();
    }
}
