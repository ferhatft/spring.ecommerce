package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
