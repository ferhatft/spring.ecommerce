package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.City;
import com.example.spring_ecommerce.services.abstracts.CityService;
import com.example.spring_ecommerce.services.dtos.city.request.AddCityRequest;
import com.example.spring_ecommerce.services.dtos.city.request.UpdateCityRequest;
import com.example.spring_ecommerce.services.dtos.city.response.ListCityResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/city")
@AllArgsConstructor
public class CityController {
    private CityService cityService;

    @GetMapping
    public List<ListCityResponse> get() {


        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<City> getByID(@PathVariable int id) {
        return cityService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCityRequest request) {
        cityService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCityRequest request) {
        cityService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        cityService.delete(id);
    }


}
