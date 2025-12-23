package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/apartment-units")
public class ApartmentUnitController {

    @Autowired
    private ApartmentUnitService apartmentUnitService;

    // Get an apartment unit by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApartmentUnit> getApartmentUnitById(@PathVariable Long id) {
        // Fetch the unit using Optional
        ApartmentUnit unit = apartmentUnitService.getApartmentUnitById(id)
                .orElseThrow(() -> new RuntimeException("Apartment unit not found with id: " + id));

        return ResponseEntity.ok(unit);
    }
}
