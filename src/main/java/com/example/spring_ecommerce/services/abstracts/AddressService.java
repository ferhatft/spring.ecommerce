package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAll();

    Optional<Address> getByID(int id);

    void add(Address addres);

    void update(Address addres);

    void delete(int id);
}
