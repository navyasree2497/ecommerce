package com.server.ecommerce.controller;

import com.server.ecommerce.entity.Seller;
import com.server.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
