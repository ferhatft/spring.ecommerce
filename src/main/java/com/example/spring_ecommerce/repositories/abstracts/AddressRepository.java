package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Addres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Addres, Integer> {
}
