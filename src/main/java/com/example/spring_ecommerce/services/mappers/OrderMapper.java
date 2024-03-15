package com.example.spring_ecommerce.services.mappers;

import com.example.spring_ecommerce.entities.Brand;
import com.example.spring_ecommerce.entities.Order;
import com.example.spring_ecommerce.services.dtos.brand.request.AddBrandRequest;
import com.example.spring_ecommerce.services.dtos.order.request.AddOrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order orderFromAddRequest(AddOrderRequest request);
}
