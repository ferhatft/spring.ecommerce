package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value="Select u.id, u.first_name, u.last_name, u.email from users u\n" +
            "INNER JOIN  addresses a on u.id =a.userid\n" +
            "INNER JOIN  districts d on a.districtid=d.id\n" +
            "INNER JOIN cities c on d.cityid =c.id\n" +
            "where c.name = 'İstanbul' ", nativeQuery = true)
    List<User> findUsersInIstanbul();

    @Query("SELECT u FROM User u " +
            "INNER JOIN UserRole ur ON u.id = ur.user.id " +
            "INNER JOIN Role r ON r.id = ur.role.id " +
            "WHERE r.name = 'admin'")
    List<User> findAdminUsers();

    @Query(value="Select distinct u.id, u.first_name,u.last_name,u.email from users u\n" +
            "INNER JOIN orders o on o.userid =u.id\n" +
            "INNER JOIN order_details od on od.orderid = o.id \n" +
            "INNER JOIN products p on p.id=od.productid\n" +
            "INNER JOIN brands b on b.id =p.brandid\n" +
            "where b.name='Asus' ", nativeQuery = true)
    List<User> findUsersWithOrdersForAsusProducts();
}