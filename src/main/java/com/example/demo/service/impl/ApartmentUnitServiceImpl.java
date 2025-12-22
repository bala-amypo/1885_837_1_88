package com.example.demo.service.impl;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.service.ApartmentUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository unitRepository;

    @Override
    public ApartmentUnit saveUnit(ApartmentUnit unit) {
        return unitRepository.save(unit);
    }

    @Override
    public List<ApartmentUnit> getAllUnits() {
        return unitRepository.findAll();
    }

    @Override
    public ApartmentUnit getUnitById(Long id) {
        return unitRepository.findById(id).orElse(null);
    }
}
