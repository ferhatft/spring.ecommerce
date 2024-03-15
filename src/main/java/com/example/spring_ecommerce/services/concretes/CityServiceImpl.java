package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.CityNotFoundException;
import com.example.spring_ecommerce.entities.Category;
import com.example.spring_ecommerce.entities.City;
import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.repositories.abstracts.CityRepository;
import com.example.spring_ecommerce.services.abstracts.CityService;
import com.example.spring_ecommerce.services.dtos.city.request.AddCityRequest;
import com.example.spring_ecommerce.services.dtos.city.request.UpdateCityRequest;
import com.example.spring_ecommerce.services.dtos.city.response.ListCityResponse;
import com.example.spring_ecommerce.services.mappers.CategoryMapper;
import com.example.spring_ecommerce.services.mappers.CityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;

    @Override
    public List<ListCityResponse> getAll() {
        List<City> cities = cityRepository.findAll();

        List<ListCityResponse> response = new ArrayList<>();

        for (City city : cities) {
            ListCityResponse cityResponse = new ListCityResponse(
                    city.getName()
            );

            response.add(cityResponse);
        }

        return response;
    }

    @Override
    public Optional<City> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(AddCityRequest request) {

        City city = CityMapper.INSTANCE.cityFromAddRequest(request);
        cityRepository.save(city);

    }

    @Override
    public void update(UpdateCityRequest request) {

        Optional<City> optionalCity = cityRepository.findById(request.getId());

        if (optionalCity.isPresent()){


            Country country = new Country();
            country.setId(request.getCountryId());

            City city = optionalCity.get();
            city.setName(request.getName());
            city.setCountry(country);

            cityRepository.save(city);
        }else {
            // Handle the case where the country with the provided ID doesn't exist
            throw new CityNotFoundException("City not found with ID: " + request.getId());
        }


    }



    @Override
    public void delete(int id) {

    }
}
