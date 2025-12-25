package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;

@RestController
@RequestMapping("/api/apartment-unit")
public class ApartmentUnitController {

    @Autowired
    private ApartmentUnitService apartmentUnitService;

    @PostMapping("/assign/{userId}")
    public ApartmentUnit assignUnitToUser(@PathVariable Long userId, @RequestBody ApartmentUnit unitRequest) {
        // Fixed: assignUnitToUser returns void, so don't assign to variable
        apartmentUnitService.assignUnitToUser(userId, unitRequest);

        // Return the assigned unit (or fetch from DB if needed)
        return unitRequest;
    }

    @GetMapping("/get/{userId}")
    public ApartmentUnit getUnitByUser(@PathVariable Long userId) {
        return apartmentUnitService.getUnitByUser(userId);
    }
}
