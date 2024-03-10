package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.SupplierProduct;
import com.example.spring_ecommerce.services.dtos.supplierproduct.requests.AddSupplierProductRequest;
import com.example.spring_ecommerce.services.dtos.supplierproduct.requests.UpdateSupplierProductRequest;
import com.example.spring_ecommerce.services.dtos.supplierproduct.responses.GetSupplierProductResponse;
import com.example.spring_ecommerce.services.dtos.supplierproduct.responses.SupplierProductListResponse;

import java.util.List;
import java.util.Optional;

public interface SupplierProductService {

    List<SupplierProductListResponse> getAll();

    Optional<GetSupplierProductResponse> getByID(int id);

    void add(AddSupplierProductRequest addSupplierProductRequest);

    void update(UpdateSupplierProductRequest updateSupplierProductRequest);

    void delete(int id);

}
