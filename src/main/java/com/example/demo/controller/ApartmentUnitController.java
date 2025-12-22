package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/units")
@Tag(name = "ApartmentUnit", description = "Assign and retrieve apartment units")
public class ApartmentUnitController {

    private final ApartmentUnitService apartmentUnitService;

    public ApartmentUnitController(ApartmentUnitService apartmentUnitService) {
        this.apartmentUnitService = apartmentUnitService;
    }

    // POST /units/assign/{userId}
    @PostMapping("/assign/{userId}")
    public ResponseEntity<?> assignUnit(@PathVariable Long userId,
                                        @RequestBody ApartmentUnit unit) {
        ApartmentUnit saved = apartmentUnitService.assignUnitToUser(userId, unit);
        return ResponseEntity.ok(saved);
    }

    // GET /units/user/{userId}
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUnitByUser(@PathVariable Long userId) {
        ApartmentUnit unit = apartmentUnitService.getUnitByUser(userId);
        return ResponseEntity.ok(unit);
    }
}
