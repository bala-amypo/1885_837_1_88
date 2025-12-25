package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/units")
public class ApartmentUnitController {

    private final ApartmentUnitService apartmentUnitService;

    public ApartmentUnitController(ApartmentUnitService apartmentUnitService) {
        this.apartmentUnitService = apartmentUnitService;
    }

    @Operation(summary = "Assign apartment unit to user")
    @PostMapping("/{userId}")
    public ApartmentUnit assignUnit(
            @PathVariable Long userId,
            @RequestBody ApartmentUnit unit) {

        return apartmentUnitService.assignUnitToUser(userId, unit);
    }

    @Operation(summary = "Get apartment unit by user")
    @GetMapping("/{userId}")
    public ApartmentUnit getUnitByUser(@PathVariable Long userId) {
        return apartmentUnitService.getUnitByUser(userId);
    }
}
