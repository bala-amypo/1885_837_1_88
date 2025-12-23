package com.example.demo.service.impl;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    @Autowired
    private ApartmentUnitRepository apartmentUnitRepository;

    @Override
    public Optional<ApartmentUnit> getApartmentUnitById(Long id) {
        return apartmentUnitRepository.findById(id);
    }
}
