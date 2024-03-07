package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Addres;
import com.example.spring_ecommerce.entities.Product;
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
    public List<Addres> get() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Addres> getByID(@PathVariable int id) {
        return addressService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody Addres addres) {
        addressService.add(addres);
    }

    @PutMapping
    public void update(@RequestBody Addres addres) {
        addressService.update(addres);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        addressService.delete(id);
    }

}
