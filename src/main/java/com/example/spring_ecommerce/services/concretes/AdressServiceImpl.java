package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Addres;
import com.example.spring_ecommerce.repositories.abstracts.AddressRepository;
import com.example.spring_ecommerce.services.abstracts.AddressService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AdressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Override
    public List<Addres> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Addres> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(Addres addres) {

    }

    @Override
    public void update(Addres addres) {

    }

    @Override
    public void delete(int id) {

    }
}
