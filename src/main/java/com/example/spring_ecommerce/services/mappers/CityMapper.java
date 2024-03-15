package com.example.spring_ecommerce.services.mappers;

import com.example.spring_ecommerce.entities.City;
import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.services.dtos.city.request.AddCityRequest;
import com.example.spring_ecommerce.services.dtos.country.request.AddCountryRequest;
import lombok.experimental.SuperBuilder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    City cityFromAddRequest(AddCityRequest request);
}
