package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/apartment-units")
public class ApartmentUnitController {

    @Autowired
    private ApartmentUnitService apartmentUnitService;

    @GetMapping("/{id}")
    public ApartmentUnit getUnit(@PathVariable Long id) {
        Optional<ApartmentUnit> optionalUnit = apartmentUnitService.getApartmentUnitById(id);
        return optionalUnit.orElseThrow(() -> new RuntimeException("Unit not found"));
    }
}
