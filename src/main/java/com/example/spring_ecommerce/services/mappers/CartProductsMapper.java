package com.example.spring_ecommerce.services.mappers;

import com.example.spring_ecommerce.entities.CartProducts;
import com.example.spring_ecommerce.services.dtos.cartProduct.request.AddCartProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartProductsMapper {


    CartProductsMapper INSTANCE = Mappers.getMapper(CartProductsMapper.class);

//    CartProducts cartPoroductsFromAddRequest(AddCartProductRequest request);
}


