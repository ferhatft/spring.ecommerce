package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.City;
import com.example.spring_ecommerce.services.dtos.city.request.AddCityRequest;
import com.example.spring_ecommerce.services.dtos.city.request.UpdateCityRequest;
import com.example.spring_ecommerce.services.dtos.city.response.ListCityResponse;

import java.util.List;
import java.util.Optional;


public interface CityService {

    List<ListCityResponse> getAll();

    Optional<City> getByID(int id);

    void add(AddCityRequest request);

    void update(UpdateCityRequest request);

    void delete(int id);
}
