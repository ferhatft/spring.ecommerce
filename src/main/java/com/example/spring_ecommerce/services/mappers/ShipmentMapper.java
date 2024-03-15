package com.example.spring_ecommerce.services.mappers;

import com.example.spring_ecommerce.entities.Payment;
import com.example.spring_ecommerce.entities.Shipment;
import com.example.spring_ecommerce.services.dtos.payment.request.AddPaymentRequest;
import com.example.spring_ecommerce.services.dtos.shipment.request.AddShipmentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {

    ShipmentMapper INSTANCE = Mappers.getMapper(ShipmentMapper.class);

    Shipment shipmentFromAddRequest(AddShipmentRequest request);
}
