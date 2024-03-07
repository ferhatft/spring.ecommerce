package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.SupplierProduct;

import java.util.List;
import java.util.Optional;

public interface SupplierProductService {

    List<SupplierProduct> getAll();

    Optional<SupplierProduct> getByID(int id);

    void add(SupplierProduct supplierProduct);

    void update(SupplierProduct supplierProduct);

    void delete(int id);

}