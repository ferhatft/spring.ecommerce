package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.District;
import com.example.spring_ecommerce.services.dtos.district.request.AddDistrictRequest;

import java.util.List;
import java.util.Optional;

public interface DistrictService {
    List<District> getAll();

    Optional<District> getByID(int id);

    void add(AddDistrictRequest request);

    void update(District district);

    void delete(int id);
}
