package com.server.ecommerce.controller;

import com.server.ecommerce.entity.Seller;
import com.server.ecommerce.entity.SellerDTO;
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

    @GetMapping("/seller/{id}")
    public Seller findSellerById (@PathVariable int id){
        return service.getSellerById(id);
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
}
