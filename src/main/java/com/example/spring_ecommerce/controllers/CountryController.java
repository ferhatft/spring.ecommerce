package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.services.abstracts.CountryService;
import com.example.spring_ecommerce.services.dto.country.request.AddCountryRequest;
import com.example.spring_ecommerce.services.dto.country.request.UpdateCountryRequest;
import com.example.spring_ecommerce.services.dto.country.response.ListCountryResponse;
import jakarta.validation.Valid;
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
    public List<ListCountryResponse> get() {

        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Country> getByID(@PathVariable int id) {
        return countryService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody  @Valid AddCountryRequest request) {
        countryService.add(request);
    }

    @PutMapping
    public void update(@RequestBody  @Valid  UpdateCountryRequest request) {
        countryService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        countryService.delete(id);
    }
}
