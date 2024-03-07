package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
