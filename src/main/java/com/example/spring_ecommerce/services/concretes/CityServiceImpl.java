package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.City;
import com.example.spring_ecommerce.repositories.abstracts.CityRepository;
import com.example.spring_ecommerce.services.abstracts.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(City city) {

    }

    @Override
    public void update(City city) {

    }

    @Override
    public void delete(int id) {

    }
}
