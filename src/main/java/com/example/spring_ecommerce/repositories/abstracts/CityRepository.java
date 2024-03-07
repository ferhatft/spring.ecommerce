package com.example.spring_ecommerce.repositories.abstracts;


import com.example.spring_ecommerce.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City ,Integer> {

}

