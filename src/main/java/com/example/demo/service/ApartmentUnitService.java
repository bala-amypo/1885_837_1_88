package com.example.demo.service;

import com.example.demo.model.ApartmentUnit;
import java.util.List;

public interface ApartmentUnitService {

    ApartmentUnit createApartmentUnit(ApartmentUnit unit);

    ApartmentUnit getApartmentUnit(Long id);

    List<ApartmentUnit> getAllApartmentUnits();

    ApartmentUnit updateApartmentUnit(Long id, ApartmentUnit unit);

    void deleteApartmentUnit(Long id);
}
