package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

//    -- En fazla satış yapılan gün
    @Query("SELECT EXTRACT(HOUR FROM o.orderDate) AS saat, COUNT(*) AS toplam_satis " +
            "FROM Order o " +
            "GROUP BY EXTRACT(HOUR FROM o.orderDate) " +
            "ORDER BY toplam_satis DESC " +
            "LIMIT 1")
    List<Object[]> findMostSoldHour();

}
