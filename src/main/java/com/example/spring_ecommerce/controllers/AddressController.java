package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Address;
import com.example.spring_ecommerce.services.abstracts.AddressService;
import com.example.spring_ecommerce.services.dtos.address.request.AddAddressRequest;
import com.example.spring_ecommerce.services.dtos.address.request.UpdateAddressRequest;
import com.example.spring_ecommerce.services.dtos.address.response.ListAddressesResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/address")
@AllArgsConstructor
public class AddressController {
    private AddressService addressService;


    @GetMapping
    public List<ListAddressesResponse> get() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Address> getByID(@PathVariable int id) {
        return addressService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddAddressRequest request) {
        addressService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateAddressRequest request) {
        addressService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        addressService.delete(id);
    }

}
