package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.demo.model.*;

public interface FacilityRepository extends JpaRepository<Facility, Long> {
    Facility findByName(String name);
}
