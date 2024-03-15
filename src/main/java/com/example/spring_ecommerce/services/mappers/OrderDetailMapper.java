package com.example.spring_ecommerce.services.mappers;

import com.example.spring_ecommerce.entities.OrderDetails;
import com.example.spring_ecommerce.services.dtos.orderDetail.request.AddOrderDetailRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {

    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    OrderDetails orderDetailsFromAddRequest(AddOrderDetailRequest request);
}
