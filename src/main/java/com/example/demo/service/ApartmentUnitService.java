package com.example.demo.service;

import com.example.demo.model.ApartmentUnit;
import java.util.List;

public interface ApartmentUnitService {
    ApartmentUnit saveUnit(ApartmentUnit unit);
    List<ApartmentUnit> getAllUnits();
    ApartmentUnit getUnitById(Long id);
}
