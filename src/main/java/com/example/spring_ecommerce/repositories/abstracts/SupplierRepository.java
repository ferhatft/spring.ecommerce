package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}