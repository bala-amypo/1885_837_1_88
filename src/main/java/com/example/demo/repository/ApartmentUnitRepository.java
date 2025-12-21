package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;

public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {
    ApartmentUnit findByOwner(User user);
}
