package com.server.ecommerce.controller;

import com.server.ecommerce.entity.Customer;
import com.server.ecommerce.entity.Seller;
import com.server.ecommerce.entity.SellerDTO;
import com.server.ecommerce.entity.SellerOrderDTO;
import com.server.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RestController
public class SellerController {

    @Autowired
    private SellerService service;

    @PostMapping("/addSeller")
    public Seller addSeller(@RequestBody Seller seller){
        return service.addSeller(seller);
    }

    @PostMapping("/addSellers")
    public List<Seller> addSellers(@RequestBody List<Seller> sellers){
        return service.addSellers(sellers);
    }

    @GetMapping("/sellers")
    public List<Seller> getAllSellers(){
        return service.getSellers();
    }

//    @GetMapping("/seller/{id}")
//    public Seller findSellerById (@PathVariable int id){
//        return service.getSellerById(id);
//    }

    @GetMapping("/seller/{userName}")
    @CrossOrigin
    public List<Seller> findCustomerByName (@PathVariable String userName){
        return service.findSellerByName(userName);
    }
//    @GetMapping("/products/getSellers/{id}")
//    @CrossOrigin
//    public List<SellerDTO> findSellersByProductId(@PathVariable int id){
//        System.out.println(id);
//        return service.getSellersByProductId(id);
//    }
    @Autowired
    private EntityManager entityManager;
    @GetMapping("/products/getSellers/{id}")
    @CrossOrigin
    public List<SellerDTO> findSellersByProductId(@PathVariable int id){
        Query q = entityManager.createNativeQuery("SELECT s.id, s.name, ps.price, ps.discount  FROM sellers s " +
                "                INNER JOIN product_seller ps " +
                "                ON ps.seller_id = s.id  " +
                "                WHERE ps.product_id = ?1", SellerDTO.class);
        q.setParameter(1,id);
        return q.getResultList();
    }

    @GetMapping("/sellers/getOrders/{id}")
    @CrossOrigin
    public List<SellerOrderDTO> findOrdersBySellerId(@PathVariable int id){
        Query q = entityManager.createNativeQuery("SELECT o.id as id, p.id as product_id, p.name as product_name, o.created_time as created_time, " +
                "o.order_price, o.quantity, c.shipping_info, o.status FROM products p\n" +
                "INNER JOIN orders o\n" +
                "ON o.product_id = p.id\n" +
                "INNER JOIN product_seller ps \n" +
                "ON p.id = ps.product_id\n" +
                "INNER JOIN customer c\n" +
                "on c.id = o.customer_id\n" +
                "WHERE ps.seller_id = ?1 ;", SellerOrderDTO.class);
        q.setParameter(1,id);
        return q.getResultList();
    }
}
