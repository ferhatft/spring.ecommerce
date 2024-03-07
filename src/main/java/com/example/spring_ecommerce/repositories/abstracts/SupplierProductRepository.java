package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.SupplierProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierProductRepository extends JpaRepository<SupplierProduct, Integer> {
}