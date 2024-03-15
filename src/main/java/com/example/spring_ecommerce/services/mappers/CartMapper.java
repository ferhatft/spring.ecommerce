package com.example.spring_ecommerce.services.mappers;

import com.example.spring_ecommerce.entities.Cart;
import com.example.spring_ecommerce.services.dtos.cart.request.AddCartRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    Cart cartFromAddRequest(AddCartRequest request);
}
