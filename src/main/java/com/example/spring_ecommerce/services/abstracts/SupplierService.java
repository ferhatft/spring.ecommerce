package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Supplier;
import com.example.spring_ecommerce.services.dtos.supplier.requests.AddSupplierRequest;
import com.example.spring_ecommerce.services.dtos.supplier.requests.UpdateSupplierRequest;
import com.example.spring_ecommerce.services.dtos.supplier.responses.GetSupplierResponse;
import com.example.spring_ecommerce.services.dtos.supplier.responses.SupplierListResponse;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    List<SupplierListResponse> getAll();

    Optional<GetSupplierResponse> getByID(int id);

    void add(AddSupplierRequest addSupplierRequest);

    void update(UpdateSupplierRequest updateSupplierRequest);

    void delete(int id);

}
