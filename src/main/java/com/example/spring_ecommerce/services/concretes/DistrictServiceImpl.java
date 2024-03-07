package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.District;
import com.example.spring_ecommerce.repositories.abstracts.DistrictRepository;
import com.example.spring_ecommerce.services.abstracts.DistrictService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class DistrictServiceImpl implements DistrictService {
    private DistrictRepository districtRepository;
    @Override
    public List<District> getAll() {
        return districtRepository.findAll();
    }

    @Override
    public Optional<District> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(District district) {

    }

    @Override
    public void update(District district) {

    }

    @Override
    public void delete(int id) {

    }
}
