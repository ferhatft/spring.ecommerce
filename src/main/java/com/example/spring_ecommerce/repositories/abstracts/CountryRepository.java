package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    Optional<Country> findByName(String name);

}
