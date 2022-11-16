package com.server.ecommerce.controller;

import com.server.ecommerce.entity.Order;
import com.server.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order){
        return service.addOrder(order);
    }

    @PostMapping("/addOrders")
    public List<Order> addOrders(@RequestBody List<Order> orders){
        return service.addOrders(orders);
    }

    @GetMapping("/Orders")
    public List<Order> getAllOrders(){
        return service.getOrders();
    }

    @GetMapping("/Order/{id}")
    public Order findOrderById (@PathVariable int id){
        return service.getOrderById(id);
    }
}
