package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.City;
import com.example.spring_ecommerce.services.abstracts.CityService;
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
    public List<City> get() {
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<City> getByID(@PathVariable int id) {
        return cityService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody City city) {
        cityService.add(city);
    }

    @PutMapping
    public void update(@RequestBody City city) {
        cityService.update(city);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        cityService.delete(id);
    }


}
