package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.District;

import java.util.List;
import java.util.Optional;

public interface DistrictService {
    List<District> getAll();

    Optional<District> getByID(int id);

    void add(District district);

    void update(District district);

    void delete(int id);
}
