package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.services.dtos.country.request.AddCountryRequest;
import com.example.spring_ecommerce.services.dtos.country.request.UpdateCountryRequest;
import com.example.spring_ecommerce.services.dtos.country.response.ListCountryResponse;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<ListCountryResponse> getAll();

    Optional<Country> getByID(int id);

    void add(AddCountryRequest request);

    void update(UpdateCountryRequest request);

    void delete(int id);
}
