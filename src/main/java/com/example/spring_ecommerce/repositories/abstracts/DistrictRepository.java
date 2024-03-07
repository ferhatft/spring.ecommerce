package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District, Integer> {
}
