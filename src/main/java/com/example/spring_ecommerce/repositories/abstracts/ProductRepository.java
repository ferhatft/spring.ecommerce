package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.services.dtos.product.responses.GetMostSoldProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByName(String name);

    @Query("SELECT p.id, p.name FROM Product p")
    List<Object[]> findIdAndName();

//    -- ürünlerde fiyatı 200 den büyük olan veya stokta 2 den fazla olanlar
    List<Product> findByUnitPriceGreaterThanOrStockGreaterThan(double unitPrice, int stock);

//    -- fiyat aralığı 50 - 150 arasında olan ürünler

    List<Product> findByUnitPriceBetween(double minPrice, double maxPrice);

//    -- fiyatı ortalama fiyatın üstünde olan ürünler
    @Query("SELECT p FROM Product p WHERE p.unitPrice > (SELECT AVG(p2.unitPrice) FROM Product p2)")
    List<Product> findByUnitPriceGreaterThanAvg();



    //-- kategorisi kitap olan ürünler
    List<Product> findByCategoryName(String name);


    @Query(value="SELECT p.name, o.order_date, COUNT(od.productid) as soldProductCount\n" +
            "FROM products p\n" +
            "INNER JOIN order_details od ON od.productid = p.id\n" +
            "INNER JOIN orders o ON o.id = od.orderid\n" +
            "INNER JOIN supplier_products sp ON sp.productid = p.id\n" +
            "INNER JOIN suppliers s ON s.id = sp.supplierid\n" +
            "INNER JOIN users u ON u.id = s.userid\n" +
            "WHERE o.order_date >= CURRENT_DATE - INTERVAL '1 month'\n" +  // Modified this line
            "AND o.order_date < CURRENT_DATE\n" +
            "GROUP BY p.name, o.order_date\n" +
            "ORDER BY soldProductCount DESC\n" +
            "LIMIT 1;\n ", nativeQuery = true)
    List<Object[]> findMostSoldProductLastMonth();



}