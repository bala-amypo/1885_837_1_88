package com.example.demo.controller;

import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
@Tag(name = "Facility", description = "Manage facilities (add & list)")
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    // POST /facilities/
    @PostMapping("/")
    public ResponseEntity<?> createFacility(@RequestBody Facility facility) {
        Facility saved = facilityService.addFacility(facility);
        return ResponseEntity.ok(saved);
    }

    // GET /facilities/
    @GetMapping("/")
    public ResponseEntity<List<Facility>> listFacilities() {
        List<Facility> facilities = facilityService.getAllFacilities();
        return ResponseEntity.ok(facilities);
    }
}
