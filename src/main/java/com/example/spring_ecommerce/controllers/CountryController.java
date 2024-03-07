package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Category;
import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.services.abstracts.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountryController {
    private final CountryService countryService;

    @GetMapping
    public List<Country> get() {
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Country> getByID(@PathVariable int id) {
        return countryService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody Country country) {
        countryService.add(country);
    }

    @PutMapping
    public void update(@RequestBody Country country) {
        countryService.update(country);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        countryService.delete(id);
    }
}
