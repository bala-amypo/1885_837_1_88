package com.example.demo.serviceimpl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import com.example.demo.repository.ApartmentUnitRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ApartmentUnitService;

@Service
public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    @Autowired
    private ApartmentUnitRepository apartmentUnitRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        unit.setUser(user);
        return apartmentUnitRepository.save(unit);
    }

    @Override
    public ApartmentUnit getUnitByUser(Long userId) {
        return apartmentUnitRepository.findByUserId(userId);
    }
}
