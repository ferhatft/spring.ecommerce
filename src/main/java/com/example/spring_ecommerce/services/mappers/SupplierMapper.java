package com.example.spring_ecommerce.services.mappers;


import com.example.spring_ecommerce.entities.Supplier;
import com.example.spring_ecommerce.services.dtos.supplier.requests.AddSupplierRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SupplierMapper
{
    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    @Mapping(source = "userId", target = "user.id")
    Supplier supplierFromAddRequest(AddSupplierRequest request);
}
