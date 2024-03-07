package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.repositories.abstracts.CountryRepository;
import com.example.spring_ecommerce.services.abstracts.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class CountriesServiceImpl implements CountryService {

    private  final CountryRepository countryRepository;
    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(Country country) {

    }

    @Override
    public void update(Country country) {

    }

    @Override
    public void delete(int id) {

    }
}
