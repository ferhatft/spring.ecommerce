package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAll();
}
