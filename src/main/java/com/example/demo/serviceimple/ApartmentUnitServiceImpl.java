package com.example.demo.service.impl;

import com.example.demo.repository.*;
import com.example.demo.model.*;
import com.example.demo.service.*;

public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository unitRepo;
    private final UserRepository userRepo;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository u, UserRepository ur) {
        this.unitRepo = u;
        this.userRepo = ur;
    }

    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {
        User user = userRepo.findById(userId).orElseThrow();
        unit.setOwner(user);
        user.setApartmentUnit(unit);
        return unitRepo.save(unit);
    }

    public ApartmentUnit getUnitByUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return unitRepo.findByOwner(user).orElse(null);
    }
}
