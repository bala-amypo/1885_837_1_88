package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/apartment-units")
@RequiredArgsConstructor
public class ApartmentUnitController {

    private final ApartmentUnitService apartmentUnitService;

    /**
     * Assign a unit to a specific user
     */
    @PostMapping("/assign/{userId}")
    public ResponseEntity<ApartmentUnit> assignUnitToUser(
            @PathVariable Long userId,
            @RequestBody ApartmentUnit unit) {

        ApartmentUnit savedUnit = apartmentUnitService.assignUnitToUser(userId, unit);
        return ResponseEntity.ok(savedUnit);
    }

    /**
     * Get the apartment unit assigned to a specific user
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApartmentUnit> getUnitByUser(@PathVariable Long userId) {
        ApartmentUnit unit = apartmentUnitService.getUnitByUser(userId)
                .orElseThrow(() -> new RuntimeException("Unit not found for user ID: " + userId));
        return ResponseEntity.ok(unit);
    }
}
