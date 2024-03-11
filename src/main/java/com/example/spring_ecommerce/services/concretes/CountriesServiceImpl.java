package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.BusinessException;
import com.example.spring_ecommerce.core.types.CountryNotFoundException;
import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.repositories.abstracts.CountryRepository;
import com.example.spring_ecommerce.services.abstracts.CountryService;
import com.example.spring_ecommerce.services.dtos.country.request.AddCountryRequest;
import com.example.spring_ecommerce.services.dtos.country.request.UpdateCountryRequest;
import com.example.spring_ecommerce.services.dtos.country.response.ListCountryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class CountriesServiceImpl implements CountryService {

    private  final CountryRepository countryRepository;
    @Override
    public List<ListCountryResponse> getAll() {

        List<Country> countries = countryRepository.findAll();

        List<ListCountryResponse> response = new ArrayList<>();

        for (Country country : countries) {
            ListCountryResponse countryResponse = new ListCountryResponse(
                            country.getName()
            );

            response.add(countryResponse);
        }

        return response;

    }

    @Override
    public Optional<Country> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(AddCountryRequest request) {

        countryWithSameNameShouldNotExists(request.getName());

        Country country = new Country();
        country.setName(request.getName());


        countryRepository.save(country);

    }

    @Override
    public void update(UpdateCountryRequest request) {
        // TODO: Check from db

        Optional<Country> optionalCountry = countryRepository.findById(request.getId());

        if (optionalCountry.isPresent()) {
            Country country = optionalCountry.get();

            // Update the country's name with the new name from the request
            country.setName(request.getName());

            // Save the updated country back to the database
            countryRepository.save(country);
        } else {
            // Handle the case where the country with the provided ID doesn't exist
            throw new CountryNotFoundException("Country not found with ID: " + request.getId());
        }


    }

    @Override
    public void delete(int id) {

    }



    private void countryWithSameNameShouldNotExists(String name)
    {
        Optional<Country> countryWithSameName = countryRepository.findByName(name);
        if(countryWithSameName.isPresent())
            throw new BusinessException("Aynı isimde 2. ürün eklenemez");
    }
}
