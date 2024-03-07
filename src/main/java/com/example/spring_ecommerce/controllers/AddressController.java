package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Address;
import com.example.spring_ecommerce.services.abstracts.AddressService;
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
    public List<Address> get() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Address> getByID(@PathVariable int id) {
        return addressService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody Address addres) {
        addressService.add(addres);
    }

    @PutMapping
    public void update(@RequestBody Address addres) {
        addressService.update(addres);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        addressService.delete(id);
    }

}
