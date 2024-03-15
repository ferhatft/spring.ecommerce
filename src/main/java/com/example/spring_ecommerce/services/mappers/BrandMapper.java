package com.example.spring_ecommerce.services.mappers;

import com.example.spring_ecommerce.entities.Brand;
import com.example.spring_ecommerce.services.dtos.brand.request.AddBrandRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BrandMapper {


    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    Brand brandFromAddRequest(AddBrandRequest request);
}
