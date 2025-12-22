package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.stereotype.Service;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository apartmentUnitRepository;
    private final UserRepository userRepository;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository apartmentUnitRepository,
                                    UserRepository userRepository) {
        this.apartmentUnitRepository = apartmentUnitRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));

        // Validate floor
        if (unit.getFloor() < 0) {
            throw new BadRequestException("Invalid floor number");
        }

        // Check duplicate unit number
        if (apartmentUnitRepository.existsByUnitNumber(unit.getUnitNumber())) {
            throw new BadRequestException("Unit number constraint violation");
        }

        // Assign owner
        unit.setOwner(user);
        ApartmentUnit saved = apartmentUnitRepository.save(unit);

        // Link back to user
        user.setApartmentUnit(saved);
        userRepository.save(user);

        return saved;
    }

    @Override
    public ApartmentUnit getUnitByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));
        return apartmentUnitRepository.findByOwner(user)
                .orElseThrow(() -> new BadRequestException("No unit assigned to this user"));
    }
}
