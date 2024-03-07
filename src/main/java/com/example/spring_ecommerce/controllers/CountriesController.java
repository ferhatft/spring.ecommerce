package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.services.abstracts.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountriesController {
    private final CountryService countryService;

    @GetMapping
    public List<Country> getAll(){
        return countryService.getAll();

    }
}
