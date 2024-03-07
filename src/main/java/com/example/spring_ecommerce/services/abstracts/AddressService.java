package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Addres;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Addres> getAll();

    Optional<Addres> getByID(int id);

    void add(Addres addres);

    void update(Addres addres);

    void delete(int id);
}
