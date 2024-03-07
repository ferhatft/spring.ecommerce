package com.example.spring_ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "supplier_products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierProduct {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToOne()
    @JoinColumn(name = "supplierid")
    private Supplier supplier;

    @ManyToOne()
    @JoinColumn(name = "productid")
    private Product product;
}
