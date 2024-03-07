package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.City;

import java.util.List;
import java.util.Optional;


public interface CityService {

    List<City> getAll();

    Optional<City> getByID(int id);

    void add(City city);

    void update(City city);

    void delete(int id);
}
