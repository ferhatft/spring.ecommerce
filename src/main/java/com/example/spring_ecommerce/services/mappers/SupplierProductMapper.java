package com.example.spring_ecommerce.services.mappers;


import com.example.spring_ecommerce.entities.SupplierProduct;
import com.example.spring_ecommerce.services.dtos.supplierproduct.requests.AddSupplierProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SupplierProductMapper
{
    SupplierProductMapper INSTANCE = Mappers.getMapper(SupplierProductMapper.class);

    @Mapping(source = "supplierId", target = "supplier.id")
    @Mapping(source = "productId", target = "product.id")
    SupplierProduct supplierProductFromAddRequest(AddSupplierProductRequest request);
}