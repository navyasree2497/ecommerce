package com.server.ecommerce.service;

import com.server.ecommerce.entity.Order;
import com.server.ecommerce.entity.OrderDTO;
import com.server.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Order addOrder(Order order){
        return repository.save(order);
    }

    public List<Order> addOrders(List<Order> orders){
        return repository.saveAll(orders);
    }

    public List<Order> getOrders(){
        return repository.findAll();
    }
//    public List<Order> getAllOrdersNative(){
//        return repository.getAllOrdersNative();
//    }
//
//    public List<OrderDTO> getAllOrdersNativeDTO(){
//        return repository.getAllOrdersNativeDTO();
//    }

    public Order getOrderById(int id){
        return repository.findById(id).orElse(null);
    }
}
