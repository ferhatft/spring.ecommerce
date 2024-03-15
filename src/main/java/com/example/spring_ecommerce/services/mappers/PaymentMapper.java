package com.example.spring_ecommerce.services.mappers;


import com.example.spring_ecommerce.entities.District;
import com.example.spring_ecommerce.entities.Payment;
import com.example.spring_ecommerce.services.dtos.district.request.AddDistrictRequest;
import com.example.spring_ecommerce.services.dtos.payment.request.AddPaymentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    Payment paymentFromAddRequest(AddPaymentRequest request);
}
