package com.example.spring_ecommerce.services.mappers;



import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.services.dtos.country.request.AddCountryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    Country countryFromAddRequest(AddCountryRequest request);
}
