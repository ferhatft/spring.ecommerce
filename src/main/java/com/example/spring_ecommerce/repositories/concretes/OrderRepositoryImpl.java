package com.example.spring_ecommerce.repositories.concretes;

import com.example.spring_ecommerce.entities.Order;
import com.example.spring_ecommerce.repositories.abstracts.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private List<Order> orderList = new ArrayList<>();

    public OrderRepositoryImpl(List<Order> orderList) {
        this.orderList = orderList;
        orderList.add(new Order(1,1,1,1,"01-03-2024",1000,"UPS"));
        orderList.add(new Order(2,2,2,2,"02-03-2024",2000,"FedEx"));
    }

    @Override
    public List<Order> getAll() {
        return orderList;
    }

    @Override
    public Order getByID(int id) {
        for (Order order : orderList) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public void add(Order order) {
        orderList.add(order);
    }

    @Override
    public void update(int id, Order order) {
        int index = 0;
        for (Order orderToUpdate : orderList) {
            if (orderToUpdate.getId() == id) {
                index = orderList.indexOf(orderToUpdate);
            }
        }
        orderList.set(index, order);
    }

    @Override
    public void delete(int id) {
        Order orderToDelete = getByID(id);
        orderList.remove(orderToDelete);
    }
}
