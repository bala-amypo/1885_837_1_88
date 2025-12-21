package com.example.demo.service.impl;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ApartmentUnitService {

    private final ApartmentUnitRepository apartmentUnitRepository;
    private final UserRepository userRepository;

    // ⚠️ constructor order STRICT
    public ApartmentUnitService(ApartmentUnitRepository apartmentUnitRepository,
                                UserRepository userRepository) {
        this.apartmentUnitRepository = apartmentUnitRepository;
        this.userRepository = userRepository;
    }

    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {
        User user = userRepository.findById(userId).orElse(null);
        unit.setOwner(user);
        return apartmentUnitRepository.save(unit);
    }

    public ApartmentUnit getUnitByUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return apartmentUnitRepository.findByOwner(user);
    }
}
