package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.SupplierProduct;
import com.example.spring_ecommerce.services.dtos.supplierproduct.responses.ProductSupplierCountResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierProductRepository extends JpaRepository<SupplierProduct, Integer> {
    @Query(value = "Select new com.example.spring_ecommerce.services.dtos.supplierproduct.responses.ProductSupplierCountResponse " +
            "(sp.product.id AS productid, COUNT(sp.supplier.id) AS supplierCount)" +
            " FROM SupplierProduct sp" +
            " GROUP BY sp.product.id"+
            " HAVING COUNT(sp.supplier.id) > 1"
    )
    List<ProductSupplierCountResponse> findProductsBySupplierCountGreaterThanOne();
}