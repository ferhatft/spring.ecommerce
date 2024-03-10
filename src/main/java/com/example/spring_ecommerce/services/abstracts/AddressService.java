package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Address;
import com.example.spring_ecommerce.services.dto.address.request.AddAddressRequest;
import com.example.spring_ecommerce.services.dto.address.request.UpdateAddressRequest;
import com.example.spring_ecommerce.services.dto.address.response.ListAddressResponse;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<ListAddressResponse> getAll();

    Optional<Address> getByID(int id);

    void add(AddAddressRequest request);

    void update(UpdateAddressRequest request);

    void delete(int id);
}
