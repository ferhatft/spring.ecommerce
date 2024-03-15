package com.example.spring_ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Table(name = "suppliers")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Supplier {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @OneToOne()
    @JoinColumn(name = "userid")
    private User user;

    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    private List<SupplierProduct> supplierProducts;
}
