package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> getAll();

    Optional<Country> getByID(int id);

    void add(Country country);

    void update(Country country);

    void delete(int id);
}
