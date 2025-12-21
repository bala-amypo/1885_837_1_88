package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.demo.model.*;

public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {
    ApartmentUnit findByOwner(User user);
}
