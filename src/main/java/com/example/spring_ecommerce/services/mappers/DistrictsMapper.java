package com.example.spring_ecommerce.services.mappers;


import com.example.spring_ecommerce.entities.District;
import com.example.spring_ecommerce.services.dtos.district.request.AddDistrictRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DistrictsMapper {

    DistrictsMapper INSTANCE = Mappers.getMapper(DistrictsMapper.class);

    District districtFromAddRequest(AddDistrictRequest request);
}

