package com.example.spring_ecommerce.repositories.abstracts;


import com.example.spring_ecommerce.entities.CartProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProducts, Integer>  {

}
