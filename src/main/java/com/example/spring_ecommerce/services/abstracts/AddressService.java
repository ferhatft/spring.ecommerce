package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Address;
import com.example.spring_ecommerce.services.dtos.address.request.AddAddressRequest;
import com.example.spring_ecommerce.services.dtos.address.request.UpdateAddressRequest;
import com.example.spring_ecommerce.services.dtos.address.response.ListAddressesResponse;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<ListAddressesResponse> getAll();

    Optional<Address> getByID(int id);

    void add(AddAddressRequest request);

    void update(UpdateAddressRequest request);

    void delete(int id);
}
