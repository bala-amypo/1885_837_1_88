package com.example.demo.service;

import com.example.demo.model.ApartmentUnit;
import java.util.Optional;

public interface ApartmentUnitService {
    ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit);
    Optional<ApartmentUnit> getUnitByUser(Long userId);
}
