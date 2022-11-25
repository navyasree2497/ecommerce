package com.server.ecommerce.controller;

import com.server.ecommerce.entity.Order;
import com.server.ecommerce.entity.OrderDTO;
import com.server.ecommerce.entity.SellerDTO;
import com.server.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

//    @GetMapping("/ordersNative")
//    public List<Order> getAllOrdersNative(){
//        return service.getAllOrdersNative();
//    }

//    @GetMapping("/ordersNativeDTO")
//    public List<OrderDTO> getAllOrdersNativeDTO(){
//        return service.getAllOrdersNativeDTO();
//    }

    @GetMapping("/Orders")
    public List<Order> getAllOrders(){
        return service.getOrders();
    }

    @GetMapping("/Order/{id}")
    public Order findOrderById (@PathVariable int id){
        return service.getOrderById(id);
    }

    @Autowired
    private EntityManager entityManager;
    @GetMapping("/customers/getOrders/{id}")
    @CrossOrigin
    public List<Order> findOrdersByCustomerId(@PathVariable int id){
        Query q = entityManager.createNativeQuery("SELECT * FROM orders where customer_id = ( ?1 )", Order.class);
        q.setParameter(1,id);
        return q.getResultList();
    }
}
