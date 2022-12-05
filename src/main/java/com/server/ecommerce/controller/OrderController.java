package com.server.ecommerce.controller;

import com.server.ecommerce.entity.Order;
import com.server.ecommerce.entity.OrderDTO;
import com.server.ecommerce.entity.SellerDTO;
import com.server.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
    Random rand = new Random();
    @PostMapping("/placeOrder/insert")
    @CrossOrigin
    @Transactional
    public List<Order> findOrdersByCustomerId(@RequestBody List<Order> order){
        Query q = entityManager.createNativeQuery("INSERT INTO orders(id, created_time, gift_wrap, order_price, quantity, customer_id, product_id, seller_id) " +
                "VALUES ( ?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8 )", Order.class);
//        System.out.println(order.get(0).getProductId());
        q.setParameter(1,rand.nextInt(10000000));
        q.setParameter(2, System.currentTimeMillis());
        q.setParameter(3,0);
        q.setParameter(4,order.get(0).getOrder_price());
        q.setParameter(5,order.get(0).getQuantity());
        q.setParameter(6,order.get(0).getCustomerId());
        q.setParameter(7,order.get(0).getProductId());
        q.setParameter(8,order.get(0).getSellerId());

        entityManager.joinTransaction();
        q.executeUpdate();
        return null;
    }

    @GetMapping("/orders/updateOrderStatus")
    @CrossOrigin
    @Transactional
    public List<Order> updateOrderStatus(@RequestParam Map<String, String> reqParam){
        Query q = entityManager.createNativeQuery("UPDATE orders SET status = ?1 WHERE id = ?2 ;", Order.class);

        System.out.println( reqParam.get("status"));
        System.out.println( reqParam.get("orderId"));
        q.setParameter(1, reqParam.get("status"));
        q.setParameter(2, reqParam.get("orderId"));

        entityManager.joinTransaction();
        q.executeUpdate();
        return null;
    }
}
