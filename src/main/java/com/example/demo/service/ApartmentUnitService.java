package com.example.demo.service;

import com.example.demo.model.ApartmentUnit;

import java.util.Optional;

public interface ApartmentUnitService {
    Optional<ApartmentUnit> getApartmentUnitById(Long id);
}
