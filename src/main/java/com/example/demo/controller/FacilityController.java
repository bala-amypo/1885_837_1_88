// package com.example.demo.controller;

// import com.example.demo.model.Facility;
// import com.example.demo.service.FacilityService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/facilities")
// public class FacilityController {

//     @Autowired
//     private FacilityService facilityService;

//     @PostMapping
//     public Facility addFacility(@RequestBody Facility facility) {
//         return facilityService.saveFacility(facility);
//     }

//     @GetMapping
//     public List<Facility> getAllFacilities() {
//         return facilityService.getAllFacilities();
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; // <- Added import

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping
    public Facility addFacility(@RequestBody Facility facility) {
        return facilityService.addFacility(facility);
    }

    @GetMapping
    public List<Facility> getAllFacilities() {
        return facilityService.getAllFacilities();
    }
}
