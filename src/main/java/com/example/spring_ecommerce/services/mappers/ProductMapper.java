package com.example.spring_ecommerce.services.mappers;


import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.services.dtos.product.requests.AddProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper
{
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "brandId", target = "brand.id")
    Product productFromAddRequest(AddProductRequest request);
}