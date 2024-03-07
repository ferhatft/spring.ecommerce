package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    List<Supplier> getAll();

    Optional<Supplier> getByID(int id);

    void add(Supplier supplier);

    void update(Supplier supplier);

    void delete(int id);

}
