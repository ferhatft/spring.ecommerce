package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.SupplierProduct;
import com.example.spring_ecommerce.services.dtos.supplierproduct.requests.AddSupplierProductRequest;
import com.example.spring_ecommerce.services.dtos.supplierproduct.requests.UpdateSupplierProductRequest;

import java.util.List;
import java.util.Optional;

public interface SupplierProductService {

    List<SupplierProduct> getAll();

    Optional<SupplierProduct> getByID(int id);

    void add(AddSupplierProductRequest addSupplierProductRequest);

    void update(UpdateSupplierProductRequest updateSupplierProductRequest);

    void delete(int id);

}
