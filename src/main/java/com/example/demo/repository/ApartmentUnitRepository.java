package com.example.demo.repository;

import com.example.demo.model.ApartmentUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {

    // ✅ Add this method to fix findByOwnerId error
    Optional<ApartmentUnit> findByOwnerId(Long ownerId);
}
