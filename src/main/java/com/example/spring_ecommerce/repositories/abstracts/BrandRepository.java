package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
