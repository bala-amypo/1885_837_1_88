package com.example.demo.serviceimpl;

import org.springframework.stereotype.Service;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    @Override
    public void assignUnitToUser(Long userId, ApartmentUnit unit) {
        // TODO: Implement assignment logic
    }

    @Override
    public ApartmentUnit getUnitByUser(Long userId) {
        // TODO: Implement retrieval logic
        return null;
    }
}
