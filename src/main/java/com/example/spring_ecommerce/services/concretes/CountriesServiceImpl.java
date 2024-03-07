package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.repositories.abstracts.CountryRepository;
import com.example.spring_ecommerce.services.abstracts.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class CountriesServiceImpl implements CountryService {
    private  final CountryRepository countryRepository;

    @Override
    public List<Country> getAll(){
        return countryRepository.findAll();
    }

}
